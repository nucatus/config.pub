package pub.config.godfather.model;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class User extends RootModel
{
    private String user;
    private String firstName;
    private String lastName;
    private String email;
    private Long organization;

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

    public void setOrganization(Long organization)
    {
        this.organization = organization;
    }

    public Long getOrganization()
    {
        return organization;
    }
}
