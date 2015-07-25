package pub.config.godfather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.config.godfather.dao.configuration.ConfigurationDao;
import pub.config.godfather.dao.configuration.items.ConfigurationItemDao;
import pub.config.godfather.model.Configuration;
import pub.config.godfather.model.ConfigurationItem;
import pub.config.godfather.model.User;
import pub.config.godfather.security.SecurityHelper;

import java.util.Collection;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@Service
public class ConfigurationItemsService extends BasicService<ConfigurationItem, ConfigurationItemDao>
{

    @Autowired
    public ConfigurationItemsService(ConfigurationItemDao dao)
    {
        super(dao);
    }

    public ConfigurationItem create(
            ConfigurationItem entity,
            Long configurationId)
    {
        User creator = SecurityHelper.getCurrentLoggedInUser();
        return dao.create(entity, creator, configurationId);
    }


    public Collection<ConfigurationItem> getConfigurationItemsForConfiguration(
            Long configurationId)
    {
        return dao.getConfigurationItemsForConfiguration(configurationId);
    }

    /**
     * There is no point in returning all the configuration
     * items for an organization
     * @return
     */
    @Override
    public Collection<ConfigurationItem> getAll()
    {
        throw new IllegalArgumentException("This call is not supported");
    }
}
