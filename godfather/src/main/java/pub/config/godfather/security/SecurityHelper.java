package pub.config.godfather.security;

import pub.config.godfather.model.Organization;
import pub.config.godfather.model.User;

import java.util.UUID;

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
        u.setId(UUID.fromString("C2B33A6F-374D-11E5-914E-0242AC110001"));
        u.setUsername("nucatus");
        u.setFirstName("Alexandru");
        u.setLastName("Ionita");
        u.setEmail("alexandru.ionita@gmail.com");
        Organization igenox = new Organization("Igenox");
        igenox.setId(UUID.fromString("43B97CD5-374D-11E5-914E-0242AC110001"));
        u.setOrganization(igenox.getId());
        return u;
    }
}
