package pub.config.godfather.dao.environment;

import org.springframework.jdbc.core.RowMapper;
import pub.config.godfather.model.Environment;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class EnvironmentRowMapper implements RowMapper<Environment>
{
    @Override
    public Environment mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Environment env = new Environment();
        env.setId(rs.getLong("id"));
        env.setName(rs.getString("name"));
        env.setType(Environment.EnvironmentType.getById(
                rs.getInt("type")));
        return env;
    }
}
