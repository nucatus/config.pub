package pub.config.godfather.dao.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pub.config.godfather.dao.BasicDao;
import pub.config.godfather.dao.UuidHelper;
import pub.config.godfather.model.Configuration;
import pub.config.godfather.model.User;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@Component
public class ConfigurationDao extends
        BasicDao<Configuration, ConfigurationSqlInventory>
{

    @Autowired
    public ConfigurationDao(DataSource dataSource)
    {
        super(dataSource);
        defaultRowMapper = new ConfigurationRowMapper();
        crudSql = ConfigurationSqlInventory.BASE;
    }

    public Configuration create(Configuration configuration,
                                User creator,
                                UUID artifactId)
    {
        return createWithParams(configuration, creator, UuidHelper.getValue(artifactId));
    }

    @Override
    protected Configuration createWithParams(Configuration entity,
                                             User creator,
                                             Object... objects)
    {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", entity.getName());
        parameters.put("creator", UuidHelper.getValue(creator.getId()));
        parameters.put("environment", entity.getEnvironmentId().map(UUID::toString).orElse(null));
        parameters.put("artifact", objects[0]);
        parameters.put("version_major", entity.getVersion().getMajor());
        parameters.put("version_minor", entity.getVersion().getMinor());
        parameters.put("version_patch", entity.getVersion().getPatch());
        parameters.put("version_stage", entity.getVersion().getStage().getOrder());
        parameters.put("parent", entity.getConfigurationParent().map(UUID::toString).orElse(null));
        return super.create(parameters);
    }

    public Collection<Configuration> getConfigurationsForArtifact(UUID artifactId)
    {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("artifact", UuidHelper.getValue(artifactId));
        return jdbcTemplate.query(
                crudSql.LIST_CONFIGURATIONS_FOR_ARTIFACT.getQuery(),
                parameters,
                defaultRowMapper);
    }

    public Collection<Configuration> getConfigurationsForEnvironment(UUID environmentId)
    {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("environment", environmentId);
        return jdbcTemplate.query(
                crudSql.LIST_CONFIGURATIONS_FOR_ENVIRONMENT.getQuery(),
                parameters,
                defaultRowMapper);
    }
}
