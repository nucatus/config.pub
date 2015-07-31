package pub.config.godfather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.config.godfather.dao.user.UserDao;
import pub.config.godfather.model.User;
import pub.config.godfather.security.SecurityHelper;

import java.util.Collection;
import java.util.UUID;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@Service
public class UsersService extends BasicService<User, UserDao>
{

    @Autowired
    public UsersService(UserDao dao)
    {
        super(dao);
    }

    public User create(User entity)
    {
        User creator = SecurityHelper.getCurrentLoggedInUser();
        return dao.create(entity, creator);
    }

    public Collection<User> getUsersForCurrentAccount()
    {
        UUID organizationId = SecurityHelper.getCurrentLoggedInUser().getOrganization();
        return dao.getAll(organizationId);
    }
}

