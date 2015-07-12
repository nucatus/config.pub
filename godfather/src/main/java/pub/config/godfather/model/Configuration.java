package pub.config.godfather.model;

import java.util.List;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class Configuration extends RootModel
{
    private Artifact artifact;
    private Environment environment;
    private Configuration seed;
    private List<ConfigurationItem> configItems;
    private Version version;

    public Artifact getArtifact()
    {
        if (artifact == null && seed != null)
        {
            return seed.getArtifact();
        }
        return artifact;
    }

    public void setArtifact(Artifact artifact)
    {
        this.artifact = artifact;
    }

    public Environment getEnvironment()
    {
        if (environment == null && seed != null)
        {
            return seed.getEnvironment();
        }
        return environment;
    }

    public void setEnvironment(Environment environment)
    {
        this.environment = environment;
    }

    public Configuration getSeed()
    {
        return seed;
    }

    public void setSeed(Configuration seed)
    {
        this.seed = seed;
    }

    public List<ConfigurationItem> getConfigItems()
    {
        return configItems;
    }

    public void setConfigItems(List<ConfigurationItem> configItems)
    {
        this.configItems = configItems;
    }

    public Version getVersion()
    {
        return version;
    }

    public void setVersion(Version version)
    {
        this.version = version;
    }
}
