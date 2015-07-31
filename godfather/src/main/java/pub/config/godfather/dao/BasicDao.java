package pub.config.godfather.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import pub.config.godfather.model.RootModel;
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
public abstract class BasicDao<T extends RootModel, K extends CrudSqlInventory>
{
    protected NamedParameterJdbcTemplate jdbcTemplate;
    protected RowMapper<T> defaultRowMapper;
    protected K crudSql;

    public BasicDao(DataSource dataSource)
    {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public T getById(final UUID id)
    {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);
        T found = jdbcTemplate.queryForObject(
                crudSql.GET_BY_ID(),
                parameters, defaultRowMapper);
        return found;
    }

    protected T create(final Map<String, Object> sqlParams)
    {
        UUID generatedId = nextSeq();
        sqlParams.put("id", generatedId);
        jdbcTemplate.update(crudSql.CREATE(), sqlParams);
        return getById(generatedId);
    }

    /**
     * This method shouldn't be used from outside the DAO layer
     * since it doesn't present a strict contract. Proxy methods
     * that have strict contract should be defined.
     * @param entity the entity to be created
     * @param creator the creator of the entity
     * @param objects parameters needed to create the entity
     * @return the created entity
     */
    protected abstract T createWithParams(T entity, User creator, Object... objects);

    public boolean deleteById(final UUID id)
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

    protected UUID nextSeq()
    {
        return UUID.randomUUID();
    }

    public Collection<T> getAll(UUID organizationId)
    {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("organization", organizationId.toString());
        return jdbcTemplate.query(
                crudSql.GET_ALL(), parameters, defaultRowMapper);
    }
}
