package pub.config.godfather.dao.user;

import org.springframework.jdbc.core.RowMapper;
import pub.config.godfather.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

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
        user.setId(UUID.fromString(rs.getString("id")));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setUsername(rs.getString("username"));
        user.setOrganization(UUID.fromString(rs.getString("organization")));
        return user;
    }
}
