package pub.config.godfather.dao.artifact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import pub.config.godfather.dao.BasicDao;
import pub.config.godfather.model.Artifact;
import pub.config.godfather.model.User;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static pub.config.godfather.dao.artifact.ArtifactSql.*;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@Component
public class ArtifactDao extends BasicDao<Artifact, ArtifactSql>
{

    @Autowired
    public ArtifactDao(DataSource dataSource)
    {
        super(dataSource);
        defaultRawMapper = new ArtifactRowMapper();
        crudSql = ArtifactSql.BASE;
    }

    public Artifact create(Artifact artifact, User creator)
    {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", artifact.getName());
        parameters.put("creator", creator.getId());
        parameters.put("organization", creator.getOrganization().getId());
        return super.create(parameters);
    }
}
