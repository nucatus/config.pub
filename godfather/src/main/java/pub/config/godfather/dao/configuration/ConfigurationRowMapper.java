package pub.config.godfather.dao.configuration;

import org.springframework.jdbc.core.RowMapper;
import pub.config.godfather.model.Configuration;
import pub.config.godfather.model.Version;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class ConfigurationRowMapper implements RowMapper<Configuration>
{
    @Override
    public Configuration mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Configuration configuration = new Configuration();
        Version version = new Version();
        configuration.setName(rs.getString("NAME"));
        configuration.setArtifactId(UUID.fromString(rs.getString("artifact")));
        configuration.setEnvironmentId(UUID.fromString(rs.getString("environment")));
        configuration.setConfigurationParent(UUID.fromString(rs.getString("parent")));
        configuration.setId(UUID.fromString(rs.getString("id")));
        version.setMajor(rs.getInt("VERSION_MAJOR"));
        version.setMinor(rs.getInt("VERSION_MINOR"));
        version.setPatch(rs.getInt("VERSION_PATCH"));
        version.setStage(Version.VersionStage.lookup(rs.getInt("VERSION_STAGE")));
        configuration.setVersion(version);
        return configuration;
    }
}
