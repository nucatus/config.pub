package pub.config.godfather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.config.godfather.dao.user.UserDao;
import pub.config.godfather.model.User;
import pub.config.godfather.security.SecurityHelper;

import java.util.Collection;

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
        Long organizationId = SecurityHelper.getCurrentLoggedInUser().getId();
        return dao.getAll(organizationId);
    }
}

