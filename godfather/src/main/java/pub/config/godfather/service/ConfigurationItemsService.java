package pub.config.godfather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.config.godfather.dao.configuration.ConfigurationDao;
import pub.config.godfather.dao.configuration.items.ConfigurationItemDao;
import pub.config.godfather.model.Configuration;
import pub.config.godfather.model.ConfigurationItem;
import pub.config.godfather.model.User;
import pub.config.godfather.security.SecurityHelper;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@Service
public class ConfigurationItemsService extends BasicService<ConfigurationItem, ConfigurationItemDao>
{

    @Autowired
    ConfigurationsService configService;

    @Autowired
    public ConfigurationItemsService(ConfigurationItemDao dao)
    {
        super(dao);
    }

    public ConfigurationItem create(
            ConfigurationItem entity,
            UUID configurationId)
    {
        User creator = SecurityHelper.getCurrentLoggedInUser();
        return dao.create(entity, creator, configurationId);
    }


    public Collection<ConfigurationItem> getConfigurationItemsForConfiguration(
            UUID configurationId)
    {
        Map<String, ConfigurationItem> chainItems = new HashMap<>();
        Stack<Configuration> configHierarchy = getInheritanceChain(configurationId);

        while (!configHierarchy.isEmpty())
        {
            UUID childConfigId = configHierarchy.pop().getId();
            Map<String, ConfigurationItem> currentConfigurationInHierarchyItems =
                    dao.getConfigurationItemsForConfiguration(childConfigId)
                            .stream().collect(
                            toMap(ConfigurationItem::getName, Function.identity()));
            // A null comment on a child won't override the non-null comment
            // on a parent, thus a map merge is implemented
            currentConfigurationInHierarchyItems.entrySet().stream()
                    .forEach(child -> chainItems.merge(
                            child.getKey(),
                            child.getValue(),
                            (oldVal, newVal) -> {
                                ConfigurationItem mergedItem = new ConfigurationItem(newVal);
                                if (oldVal.getComment() != null && newVal.getComment() == null)
                                {
                                    mergedItem.setComment(oldVal.getComment());
                                }
                                return mergedItem;
                            }));
        }
        return chainItems.values();
    }

    private Stack<Configuration> getInheritanceChain(UUID configurationId)
    {
        Stack<Configuration> configHierarchy = new Stack<>();
        Configuration configuration = configService.getById(configurationId);
        configHierarchy.push(configuration);
        UUID parentId;
        while ((parentId = configuration.getConfigurationParent()) != null)
        {
            configuration = configService.getById(parentId);
            configHierarchy.push(configuration);
        }
        return configHierarchy;
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

    public String getConfigurationItemsAsString(final UUID configId)
    {
        return getConfigurationItemsForConfiguration(configId)
                .stream().map(configItem ->
                        configItem.getName() + "=" + String.valueOf(configItem.getValue()))
                .collect(joining("\n"));
    }
}
