package pub.config.client;

import pub.config.client.model.Configuration;
import pub.config.client.model.Environment;
import pub.config.client.model.Version;

import java.io.Closeable;

/**
 * Created by alexandru.ionita on 3/3/15.
 */
public interface GfClient extends Closeable
{
    /**
     * Grab configuration based on query parameters
     * @param configurationName
     * @param configurationVersion
     * @param environment
     * @return
     */
    Configuration getConfiguration(final String configurationName,
                                   final Version configurationVersion,
                                   final Environment environment) throws GfException;
}
