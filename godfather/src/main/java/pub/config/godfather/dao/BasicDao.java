package pub.config.godfather.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import pub.config.godfather.dao.artifact.ArtifactRowMapper;
import pub.config.godfather.model.Artifact;
import pub.config.godfather.model.RootModel;
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
public abstract class BasicDao<T extends RootModel, K extends CrudSqlInventory>
{
    protected NamedParameterJdbcTemplate jdbcTemplate;
    protected RowMapper<T> defaultRawMapper;
    protected K crudSql;

    public BasicDao(DataSource dataSource)
    {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public T getById(final Long id)
    {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);
        T found = jdbcTemplate.queryForObject(
                crudSql.GET_BY_ID(),
                parameters, defaultRawMapper);
        return found;
    }

    protected T create(final Map<String, Object> sqlParams)
    {
        Long generatedId = nextSeq();
        sqlParams.put("id", generatedId);
        jdbcTemplate.update(crudSql.CREATE(), sqlParams);
        return getById(generatedId);
    }

    public abstract T create(T artifact, User creator);

    public boolean deleteById(final Long id)
    {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);
        int rowsCount = jdbcTemplate.update(
                crudSql.DELETE(),
                parameters);
        return rowsCount > 0;
    }

    public boolean delete(T t)
    {
        return deleteById(t.getId());
    }

    private Long nextSeq()
    {
        return jdbcTemplate.queryForObject(
                BasicSqlInventory.NEXT_SEQ.getQuery(),
                new HashMap<>(),
                Long.class);
    }

    public Collection<T> getAll(Long organizationId)
    {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("organization", organizationId);
        return jdbcTemplate.query(
                crudSql.GET_ALL(), parameters, defaultRawMapper);
    }
}
