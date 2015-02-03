package pub.config.godfather.service;

import pub.config.godfather.domain.ConfigurationSet;
import pub.config.godfather.domain.Environment;
import pub.config.godfather.domain.Version;

/**
 * Created by alexandru.ionita on 1/17/15.
 */
public class ConfigurationPersisterService
{
    /**
     * Add a new configuration to the system. This action should be executed once in
     * the lifetime of a configuration.
     * @param configuration
     */
    public void addConfiguration(ConfigurationSet configuration)
    {

    }

    /**
     * A configuration can be tagged.
     * @param configuration the configuration to be tagged
     * @param tagName the tag name to be assigned
     */
    public void tagConfiguration(ConfigurationSet configuration, String tagName)
    {

    }

    /**
     * Configurations can be versioned to match, but not necessarily, the version
     * of the component it configures.
     * @param configuration the configuration to be versioned
     * @param newVersion the version to be assigned
     */
    public void versionConfiguration(ConfigurationSet configuration, Version newVersion)
    {

    }

    /**
     * Promote the configuration to a new environment
     * @param configuration the configuration to be promoted
     * @param newEnv the targeted environment
     */
    public void promoteConfiguration(ConfigurationSet configuration, Environment newEnv)
    {

    }
}
