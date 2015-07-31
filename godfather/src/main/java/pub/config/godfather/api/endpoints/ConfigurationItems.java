package pub.config.godfather.api.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pub.config.godfather.api.util.ApiPageResult;
import pub.config.godfather.model.Configuration;
import pub.config.godfather.model.ConfigurationItem;
import pub.config.godfather.service.ConfigurationItemsService;
import pub.config.godfather.service.ConfigurationsService;

import java.util.UUID;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@RestController
@RequestMapping("/api/artifacts/{artifactId}/configurations/{configId}/items")
public class ConfigurationItems extends BasicEndpoint<ConfigurationItem, ConfigurationItemsService>
{
    @Autowired
    public ConfigurationItems(ConfigurationItemsService service)
    {
        super(service);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ApiPageResult<ConfigurationItem> getConfigurationItemsForCurrentConfiguration(
            @PathVariable final UUID configId)
    {
        return new ApiPageResult<>(service.getConfigurationItemsForConfiguration(configId));
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String getConfigurationItemsForCurrentConfigurationAsText(
            @PathVariable final UUID configId)
    {
        return service.getConfigurationItemsAsString(configId);
    }

    @RequestMapping(value = "/{configurationItemId}", method = RequestMethod.GET)
    public ConfigurationItem getConfigurationById(
            @PathVariable("configurationItemId") final UUID configurationItemId)
    {
        return getById(configurationItemId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createConfigurationItem(
            @RequestBody final ConfigurationItem configurationItem,
            @PathVariable final UUID configId)
    {
        ConfigurationItem created = service.create(configurationItem, configId);
        return decorateCreatedEntity(created);
    }

    @RequestMapping(value = "/{configurationItemId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEnvironment(
            @PathVariable("configurationItemId") final UUID configurationItemId)
    {
        return delete(configurationItemId);
    }
}
