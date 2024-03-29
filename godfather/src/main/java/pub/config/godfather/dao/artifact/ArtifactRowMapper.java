package pub.config.godfather.dao.artifact;

import org.springframework.jdbc.core.RowMapper;
import pub.config.godfather.model.Artifact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class ArtifactRowMapper implements RowMapper<Artifact>
{
    @Override
    public Artifact mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Artifact artifact = new Artifact();
        artifact.setName(rs.getString("NAME"));
        artifact.setId(UUID.fromString(rs.getString("id")));
        return artifact;
    }
}
