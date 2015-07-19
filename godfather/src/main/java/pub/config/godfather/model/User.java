package pub.config.godfather.model;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class User
{
    private Long id;
    private String user;
    private String firstName;
    private String lastName;
    private String email;
    private Organization organization;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setOrganization(Organization organization)
    {
        this.organization = organization;
    }

    public Organization getOrganization()
    {
        return organization;
    }
}
