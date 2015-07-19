package pub.config.godfather.model;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class Organization
{
    private Long id;
    private final String name;

    public Organization(String name)
    {
        this.name = name;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }
}
