package pub.config.godfather.dao.configuration.items;

import org.springframework.jdbc.core.RowMapper;
import pub.config.godfather.model.ConfigurationItem;
import pub.config.godfather.processors.ItemProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class ConfigurationItemRowMapper implements RowMapper<ConfigurationItem>
{
    @Override
    public ConfigurationItem mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        ConfigurationItem item = new ConfigurationItem();
        item.setName(rs.getString("name"));
        item.setType(ConfigurationItem.ItemType.getById(rs.getInt("type")));
        item.setId(rs.getLong("id"));
        item.setConfigurationId(rs.getLong("configuration"));
        item.setValue(rs.getString("value"));
        return ItemProcessor.deserialize(item);
    }
}
