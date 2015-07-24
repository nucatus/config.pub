package pub.config.godfather.dao.artifact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pub.config.godfather.dao.BasicDao;
import pub.config.godfather.model.Artifact;
import pub.config.godfather.model.User;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@Component
public class ArtifactDao extends BasicDao<Artifact, ArtifactSqlInventory>
{

    @Autowired
    public ArtifactDao(DataSource dataSource)
    {
        super(dataSource);
        defaultRawMapper = new ArtifactRowMapper();
        crudSql = ArtifactSqlInventory.BASE;
    }

    public Artifact create(Artifact artifact,
                           User creator)
    {
        return createWithParams(artifact,
                creator,
                creator.getOrganization().getId());
    }

    @Override
    protected Artifact createWithParams(
            Artifact artifact, User creator, Object... input)
    {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", artifact.getName());
        parameters.put("creator", creator.getId());
        parameters.put("organization", creator.getOrganization().getId());
        return super.create(parameters);
    }
}
