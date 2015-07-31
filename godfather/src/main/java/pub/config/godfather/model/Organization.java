package pub.config.godfather.model;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class Organization extends RootModel
{
    private final String name;

    public Organization(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
