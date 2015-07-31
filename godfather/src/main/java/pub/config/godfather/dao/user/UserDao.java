package pub.config.godfather.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pub.config.godfather.dao.BasicDao;
import pub.config.godfather.dao.UuidHelper;
import pub.config.godfather.model.User;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@Component
public class UserDao extends BasicDao<User, UserSqlInventory>
{
    @Autowired
    public UserDao(DataSource dataSource)
    {
        super(dataSource);
        defaultRowMapper = new UserRowMapper();
        crudSql = UserSqlInventory.BASE;
    }

    public User create(User user,
                       User creator)
    {
        return createWithParams(user, creator);
    }

    @Override
    protected User createWithParams(User entity, User creator, Object... objects)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("user_name", entity.getUsername());
        params.put("first_name", entity.getFirstName());
        params.put("last_name", entity.getLastName());
        params.put("email", entity.getEmail());
        params.put("organization", UuidHelper.getValue(creator.getOrganization()));
        return super.create(params);
    }
}
