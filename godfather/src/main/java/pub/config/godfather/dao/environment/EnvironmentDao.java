package pub.config.godfather.dao.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pub.config.godfather.dao.BasicDao;
import pub.config.godfather.model.Environment;
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
public class EnvironmentDao extends BasicDao<Environment, EnvironmentSqlInventory>
{
    @Autowired
    public EnvironmentDao(DataSource dataSource)
    {
        super(dataSource);
        defaultRowMapper = new EnvironmentRowMapper();
        crudSql = EnvironmentSqlInventory.BASE;
    }

    public Collection<Environment> getEnvironmentsForArtifact(
            UUID artifactId)
    {
        if (artifactId == null)
        {
            throw new IllegalArgumentException("Artifact ID must be non null and a valid UUID");
        }
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("artifact", artifactId.toString());
        return jdbcTemplate.query(
                crudSql.LIST_ENVIRONMENTS_FOR_ARTIFACT.getQuery(),
                parameters,
                defaultRowMapper);
    }

    public Environment create(Environment environment,
                              User creator,
                              UUID artifactId)
    {
        if (artifactId == null)
        {
            throw new IllegalArgumentException("The artifact ID must be non-null and a valid UUID");
        }
        return createWithParams(environment, creator, artifactId.toString());
    }

    @Override
    protected Environment createWithParams(
            Environment environment,
            User creator,
            Object... input)
    {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", environment.getName());
        parameters.put("creator", creator.getId().toString());
        parameters.put("type", environment.getType().getId());
        parameters.put("artifact", input[0]);
        return super.create(parameters);
    }
}
