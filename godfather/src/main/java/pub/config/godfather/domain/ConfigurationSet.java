package pub.config.godfather.domain;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by alexandru.ionita on 1/16/15.
 */
public class ConfigurationSet
{

    /**
     * Object key
     */
    @Id
    private String id;

    /**
     * This is the name of the configuration set which, in practice should match the
     * name of the component that configures.
     */
    private String name;
    /**
     * A short description that will be inserted at the top of the configuration set.
     * It will usually comprise of technical information to describe the current configuration.
     */
    private String description;
    /**
     * A configuration set which this one is derived from, if any. If null, the current configuration
     * set does not have a parent.
     */
    private ConfigurationSet parent;
    /**
     * The version of the current configuration set
     */
    @NotNull
    private Version configSetVersion;
    /**
     * The actual configuration entries
     */
    private Set<ConfigurationPair> configurationEntries;
    /**
     * The owner of the actual configuration set. This is who created the configuration set
     * and the maintainer too.
     */
    private User owner;
    /**
     * THe environment to which the configuration applies
     */
    private Environment environment;


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Set<ConfigurationPair> getConfigurationEntries()
    {
        return configurationEntries;
    }

    public void setConfigurationEntries(Set<ConfigurationPair> configurationEntries)
    {
        this.configurationEntries = configurationEntries;
    }

    public User getOwner()
    {
        return owner;
    }

    public void setOwner(User owner)
    {
        this.owner = owner;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public ConfigurationSet getParent()
    {
        return parent;
    }

    public void setParent(ConfigurationSet parent)
    {
        this.parent = parent;
    }

    public Version getConfigSetVersion()
    {
        return configSetVersion;
    }

    public void setConfigSetVersion(Version configSetVersion)
    {
        this.configSetVersion = configSetVersion;
    }

    public Environment getEnvironment()
    {
        return environment;
    }

    public void setEnvironment(Environment environment)
    {
        this.environment = environment;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }


}