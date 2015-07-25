package pub.config.godfather.model;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class Configuration extends RootModel
{
    private String name;
    private Long artifactId;
    private Long environmentId;
    private Long configurationParent;
    private Version version;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getArtifactId()
    {
        return artifactId;
    }

    public void setArtifactId(Long artifactId)
    {
        this.artifactId = artifactId;
    }

    public Long getEnvironmentId()
    {
        return environmentId;
    }

    public void setEnvironmentId(Long environmentId)
    {
        this.environmentId = environmentId;
    }

    public Long getConfigurationParent()
    {
        return configurationParent;
    }

    public void setConfigurationParent(Long configurationParent)
    {
        this.configurationParent = configurationParent;
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
