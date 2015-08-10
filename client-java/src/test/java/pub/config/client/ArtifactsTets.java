package pub.config.client;

import org.testng.annotations.Test;
import pub.config.client.model.Artifact;

import java.io.IOException;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;

/**
 * @author alexandru.ionita
 * @since 1.0
 */

public class ArtifactsTets
{
    @Test
    public void testX509Authentication() throws ClientCertificatesException, GfException, IOException
    {
        DefaultGfClient.Builder builder = new DefaultGfClient.Builder();
        builder.uri("https://config.pub:8443", new ClientCertificates());
        DefaultGfClient client = builder.build();

        Collection<Artifact> artifacts = client.getArtifacts();
        assertThat(artifacts, is(not(empty())));

    }
}
