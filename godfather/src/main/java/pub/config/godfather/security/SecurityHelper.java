package pub.config.godfather.security;

import pub.config.godfather.model.Organization;
import pub.config.godfather.model.User;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class SecurityHelper
{

    public static User getCurrentLoggedInUser()
    {
        //  TODO: refactor the dummy implementation
        User u = new User();
        u.setId(1L);
        u.setUser("nucatus");
        u.setFirstName("Alexandru");
        u.setLastName("Ionita");
        u.setEmail("alexandru.ionita@gmail.com");
        Organization igenox = new Organization("Igenox");
        igenox.setId(1L);
        u.setOrganization(igenox.getId());
        return u;
    }
}
