package pub.config.godfather.dao.configuration.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pub.config.godfather.dao.BasicDao;
import pub.config.godfather.model.ConfigurationItem;
import pub.config.godfather.model.User;
import pub.config.godfather.processors.ItemProcessor;

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
public class ConfigurationItemDao extends
        BasicDao<ConfigurationItem, ConfigurationItemSqlInventory>
{
    @Autowired
    public ConfigurationItemDao(DataSource dataSource)
    {
        super(dataSource);
        defaultRowMapper = new ConfigurationItemRowMapper();
        crudSql = ConfigurationItemSqlInventory.BASE;
    }

    @Override
    protected ConfigurationItem createWithParams(ConfigurationItem entity,
                                                 User creator,
                                                 Object... objects)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("name", entity.getName());
        params.put("value", ItemProcessor.serialize(entity));
        params.put("type", entity.getType().getId());
        params.put("configuration", objects[0]);
        return super.create(params);
    }

    public Collection<ConfigurationItem> getConfigurationItemsForConfiguration(
            final UUID configurationId)
    {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("configuration", configurationId);
        return jdbcTemplate.query(
                crudSql.LIST_CONFIGURATION_ITEMS_FOR_CONFIGURATION.getQuery(),
                parameters,
                defaultRowMapper);
    }

    public ConfigurationItem create(ConfigurationItem configurationItem,
                                    User creator,
                                    UUID configurationId)
    {
        return createWithParams(configurationItem, creator, configurationId);
    }
}

