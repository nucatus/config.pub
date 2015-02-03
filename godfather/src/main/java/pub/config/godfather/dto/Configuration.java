package pub.config.godfather.dto;

import org.springframework.hateoas.ResourceSupport;

import java.util.Set;

/**
 * Created by alexandru.ionita on 1/25/15.
 */
public class Configuration extends ResourceSupport implements Dto
{
    private String name;
    private String description;
    private Version configVersion;
    private Set<ConfigurationPair> entries;
    private Environment environment;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Version getConfigVersion()
    {
        return configVersion;
    }

    public void setConfigVersion(Version configVersion)
    {
        this.configVersion = configVersion;
    }

    public Set<ConfigurationPair> getEntries()
    {
        return entries;
    }

    public void setEntries(Set<ConfigurationPair> entries)
    {
        this.entries = entries;
    }

    public Environment getEnvironment()
    {
        return environment;
    }

    public void setEnvironment(Environment environment)
    {
        this.environment = environment;
    }
}
