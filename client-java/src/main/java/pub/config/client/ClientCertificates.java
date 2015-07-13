package pub.config.client;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.bouncycastle.openssl.*;
/**
 * Created by alexandru.ionita on 7/3/15.
 */
public class ClientCertificates
{
    public static final String DEFAULT_CA_CERT_FILE = "ca.pem";
    public static final String DEFAULT_CLIENT_CERT_FILE = "cert.pem";
    public static final String DEFAULT_CLIENT_KEY_FILE = "key.pem";

    private static final char[] LOCAL_KEY_STORE_PASSWORD = "leaveItHere@12PM".toCharArray();

    private final SSLContext sslContext;

    public ClientCertificates(final Path clientCertsPath) throws ClientCertificatesException
    {
        this(new Builder().certificatesPath(clientCertsPath));
    }

    public SSLContext getSslContext()
    {
        return sslContext;
    }

    private ClientCertificates(Builder builder) throws ClientCertificatesException
    {
        if (builder.caPath == null
                || builder.clientKeyPath == null
                || builder.clientCertPath == null)
        {
            throw new ClientCertificatesException("All three cert files have to be specified");
        }

        try
        {
            final CertificateFactory factory = CertificateFactory.getInstance("X.509");
            final Certificate caCert = factory.generateCertificate(Files.newInputStream(builder.caPath));
            final Certificate clientCert = factory.generateCertificate(Files.newInputStream(builder.clientCertPath));

            final PEMKeyPair clientKeyPair = (PEMKeyPair)new PEMParser(
                    Files.newBufferedReader(
                            builder.clientKeyPath,
                            Charset.defaultCharset()))
                    .readObject();
            final PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(
                    clientKeyPair.getPrivateKeyInfo().getEncoded());
            final KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            final PrivateKey clientPrivateKey = keyFactory.generatePrivate(keySpec);

            final KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);
            trustStore.setEntry("ca", new KeyStore.TrustedCertificateEntry(caCert), null);

            //  build the keystore
            final KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("client", clientCert);
            keyStore.setKeyEntry("key", clientPrivateKey, LOCAL_KEY_STORE_PASSWORD, new Certificate[]{clientCert});

            this.sslContext = SSLContexts.custom()
                    .loadTrustMaterial(trustStore, null)
                    .loadKeyMaterial(keyStore, LOCAL_KEY_STORE_PASSWORD)
                    .useProtocol("TLS")
                    .build();
        } catch (CertificateException |
                IOException |
                NoSuchAlgorithmException |
                InvalidKeySpecException |
                KeyStoreException |
                UnrecoverableKeyException |
                KeyManagementException e)
        {
            throw new ClientCertificatesException(e);
        }
    }

    public static class Builder
    {
        private Path caPath;
        private Path clientCertPath;
        private Path clientKeyPath;

        private Builder(){}

        private Builder certificatesPath(final Path certificatesPath)
        {
            caPath = certificatesPath.resolve(DEFAULT_CA_CERT_FILE);
            clientCertPath = certificatesPath.resolve(DEFAULT_CLIENT_CERT_FILE);
            clientKeyPath = certificatesPath.resolve(DEFAULT_CLIENT_KEY_FILE);
            return this;
        }
    }


}
