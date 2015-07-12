package pub.config.godfather.model;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class Environment extends RootModel
{

    private EnvironmentType type;
    private String name;

    public EnvironmentType getType()
    {
        return type;
    }

    public void setType(EnvironmentType type)
    {
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public enum EnvironmentType
    {
        DEV, STAGING, QA, PROD;
    }
}
