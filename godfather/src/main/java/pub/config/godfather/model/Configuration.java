package pub.config.godfather.model;

import java.util.UUID;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class Configuration extends RootModel
{
    private String name;
    private UUID artifactId;
    private UUID environmentId;
    private UUID configurationParent;
    private Version version;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public UUID getArtifactId()
    {
        return artifactId;
    }

    public void setArtifactId(UUID artifactId)
    {
        this.artifactId = artifactId;
    }

    public UUID getEnvironmentId()
    {
        return environmentId;
    }

    public void setEnvironmentId(UUID environmentId)
    {
        this.environmentId = environmentId;
    }

    public UUID getConfigurationParent()
    {
        return configurationParent;
    }

    public void setConfigurationParent(UUID configurationParent)
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
