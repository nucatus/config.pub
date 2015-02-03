package pub.config.godfather.domain;

/**
 * Created by alexandru.ionita on 1/16/15.
 */
public class User
{

    private String userId;
    private String name;
    private String email;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
