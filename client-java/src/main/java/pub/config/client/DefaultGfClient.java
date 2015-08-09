package pub.config.client;

import com.google.common.base.Preconditions;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.glassfish.jersey.apache.connector.ApacheClientProperties;
import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import pub.config.client.model.*;

import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Strings.isNullOrEmpty;
import static javax.ws.rs.HttpMethod.GET;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;

/**
 * Created by alexandru.ionita on 3/3/15.
 */
public class DefaultGfClient implements GfClient
{

    private static final long DEFAULT_CONNECT_TIMEOUT = TimeUnit.SECONDS.toMillis(5);
    private static final int DEFAULT_CONNECTION_POOL_SIZE = 100;
    private static final ClientConfig DEFAULT_CLIENT_CONFIG = new ClientConfig(
        ObjectMapperProvider.class, JacksonFeature.class);

    public static final GenericType<Listing<Artifact>> ARTIFACT_LISTING_GENERIC_TYPE =
            new GenericType<Listing<Artifact>>() {};

    private final Client client;
    private URI uri;
    private String apiVersion;

    protected DefaultGfClient(final Builder builder)
    {
        uri = Preconditions.checkNotNull(builder.uri, "uri");

        final PoolingHttpClientConnectionManager connectionManager =
                getConnectionManager(builder);

        final RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout((int) builder.connectTimeoutMillis)
                .setConnectTimeout((int) builder.connectTimeoutMillis)
                .build();

        final ClientConfig clientConfig = DEFAULT_CLIENT_CONFIG
                .connectorProvider(new ApacheConnectorProvider())
                .property(ApacheClientProperties.CONNECTION_MANAGER, connectionManager)
                .property(ApacheClientProperties.REQUEST_CONFIG, requestConfig);

        this.client = ClientBuilder.newClient(clientConfig);
    }

    private PoolingHttpClientConnectionManager getConnectionManager(Builder builder)
    {
        PoolingHttpClientConnectionManager connectionManager =
                new PoolingHttpClientConnectionManager(getConnectionRegistry(builder));
        connectionManager.setMaxTotal(builder.connectionPoolSize);
        connectionManager.setDefaultMaxPerRoute(connectionManager.getMaxTotal());

        return connectionManager;
    }

    private Registry<ConnectionSocketFactory> getConnectionRegistry(Builder builder)
    {
        final SSLConnectionSocketFactory httpsFactory =
                new SSLConnectionSocketFactory(builder.clientCertificates.getSslContext());
        final RegistryBuilder registryBuilder = RegistryBuilder.create()
                .register("https", httpsFactory);

        return registryBuilder.build();
    }

    private <T> T request(final String method,
                          final Class<T> clazz,
                          final WebTarget endpoint,
                          final Invocation.Builder request,
                          final Entity<?> entity)
            throws InterruptedException, GfException
    {
        try
        {
            return request.async().method(method, entity, clazz).get();
        }  catch (ExecutionException e)
        {
            throw classifyIt(e);
        }
    }

    private <T> Listing<T> requestListing(final String method,
                                          final GenericType<Listing<T>> type,
                                          final WebTarget endpoint,
                                          final Invocation.Builder request)
            throws GfException, IOException
    {
        try
        {
            return request.async().method(method, type).get();
        } catch (InterruptedException e)
        {
            throw classifyIt(new ExecutionException(e));
        }
        catch (ExecutionException e)
        {
            throw classifyIt(e);
        }
    }

    private WebTarget resource() {
        final WebTarget target = client.target(uri);
        if (!isNullOrEmpty(apiVersion)) {
            target.path(apiVersion);
        }
        return target;
    }

    private RuntimeException classifyIt(ExecutionException e) throws GfException
    {
        throw new GfException(e);
    }

    public Collection<Artifact> getArtifacts() throws GfException, IOException
    {
        final WebTarget resource = resource().path("info");
        Listing<Artifact> listing = requestListing(GET,
                        ARTIFACT_LISTING_GENERIC_TYPE,
                        resource,
                        resource.request(APPLICATION_JSON_TYPE));
        return listing.getData();
    }


    @Override
    public Configuration getConfiguration(
            String configurationName,
            Version configurationVersion,
            Environment environment) throws GfException
    {
        return null;
    }



    @Override
    public void close() throws IOException
    {
        client.close();
    }

    public static class Builder
    {
        private URI uri;
        private AuthPrincipal authPrincipal;
        private ClientCertificates clientCertificates;
        private long connectTimeoutMillis = DEFAULT_CONNECT_TIMEOUT;
        private int connectionPoolSize = DEFAULT_CONNECTION_POOL_SIZE;
        private String apiVersion;

        public Builder uri(final URI uri, final ClientCertificates clientCertificates)
        {
            this.clientCertificates = clientCertificates;
            this.uri = uri;
            return this;
        }

        public Builder uri(final String uri, final ClientCertificates clientCertificates)
        {
            return uri(URI.create(uri), clientCertificates);
        }

        public Builder connectionTimeout(final long connectTimeoutMillis)
        {
            this.connectTimeoutMillis = connectTimeoutMillis;
            return this;
        }
        
        public Builder connectionPoolSize(final int connectionPoolSize)
        {
            this.connectionPoolSize = connectionPoolSize;
            return this;
        }

        public Builder authPrincipal(final AuthPrincipal authPrincipal)
        {
            this.authPrincipal = authPrincipal;
            return this;
        }

        public Builder version(final String version)
        {
            this.apiVersion = version;
            return this;
        }

        public URI uri()
        {
            return uri;
        }

        public AuthPrincipal authPrincipal()
        {
            return authPrincipal;
        }

        public long connectTimeoutMillis()
        {
            return connectTimeoutMillis;
        }

        public int connectionPoolSize()
        {
            return connectionPoolSize;
        }

        public ClientCertificates getClientCertificates()
        {
            return clientCertificates;
        }

        public DefaultGfClient build()
        {
            return new DefaultGfClient(this);
        }

        public String version()
        {
            return apiVersion;
        }
    }
}
