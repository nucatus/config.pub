package pub.config.godfather.dao.artifact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import pub.config.godfather.model.Artifact;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static pub.config.godfather.dao.artifact.ArtifactSql.*;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@Component
public class ArtifactDao
{

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public ArtifactDao(DataSource dataSource)
    {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public Artifact getArtifactById(final Long id)
    {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);
        Artifact found = jdbcTemplate.queryForObject(
                GET_ARTIFACT_BY_ID.getQuery(),
                parameters, new ArtifactRowMapper());
        return found;
    }

    public Artifact getByNameAndCreator(final String name, final Long creatorId)
    {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", name);
        parameters.put("creator", creatorId);
        Artifact artifact = jdbcTemplate.queryForObject(
                GET_ARTIFACT_BY_NAME_AND_CREATOR.getQuery(),
                parameters, new ArtifactRowMapper());
        return artifact;
    }

    public boolean deleteArtifactById(final Long id)
    {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);
        int rowsCount = jdbcTemplate.update(
                DELETE_ARTIFACT_BY_ID.getQuery(),
                parameters);
        return rowsCount > 0;
    }

    public Artifact create(Artifact artifact, Long creatorId)
    {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", artifact.getName());
        parameters.put("creator", creatorId);
        jdbcTemplate.update(CREATE_ARTIFACT.getQuery(), parameters);
        return getByNameAndCreator(artifact.getName(), creatorId);
    }

}
