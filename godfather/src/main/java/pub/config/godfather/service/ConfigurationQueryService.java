package pub.config.godfather.service;

import pub.config.godfather.domain.ConfigurationSet;
import pub.config.godfather.domain.Environment;
import pub.config.godfather.domain.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by alexandru.ionita on 1/17/15.
 */
@Component
public class ConfigurationQueryService
{

    @Autowired VersionService versionService;

    /**
     * Return a configuration set based on component, version and environment. If version cannot be parsed
     * or the environment is not defined a ConfigurationException is thrown.
     * @param component the component's name
     * @param versionStr the version in three digits format of three digits plus staging string
     * @param envStr the environment string value
     * @return ConfigurationSet object populated with the configuration entries
     * @throws ConfigurationException
     */
    public ConfigurationSet getConfiguration(String component, String versionStr, String envStr) throws ConfigurationException
    {
        try
        {
            Version version = versionService.parseVersion(versionStr);
            Environment env = Environment.getByName(envStr);
            if (env == null)
            {
                throw new IllegalArgumentException("No environment defined for: " + envStr);
            }
            return getConfiguration(component, version, env);
        } catch (VersionFormatException e)
        {
            throw new ConfigurationException(e);
        }
    }

    public ConfigurationSet getConfiguration(String component, Version version, Environment env)
    {
        return null;
    }
}
