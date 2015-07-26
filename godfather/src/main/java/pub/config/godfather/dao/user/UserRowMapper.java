package pub.config.godfather.dao.user;

import org.springframework.jdbc.core.RowMapper;
import pub.config.godfather.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class UserRowMapper implements RowMapper<User>
{
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setUser(rs.getString("user"));
        user.setOrganization(rs.getLong("organization"));
        return user;
    }
}
