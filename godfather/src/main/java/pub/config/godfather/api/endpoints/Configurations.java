package pub.config.godfather.api.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pub.config.godfather.api.util.ApiPageResult;
import pub.config.godfather.model.Configuration;
import pub.config.godfather.model.Environment;
import pub.config.godfather.service.ConfigurationsService;

import java.util.UUID;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@RestController
@RequestMapping("/api/artifacts/{artifactId}")
public class Configurations extends BasicEndpoint<Configuration, ConfigurationsService>
{
    @Autowired
    public Configurations(ConfigurationsService service)
    {
        super(service);
    }

    @RequestMapping(value = "/configurations", method = RequestMethod.GET)
    public ApiPageResult<Configuration> getConfigurationsForCurrentArtifact(
            @PathVariable final UUID artifactId)
    {
        return new ApiPageResult<>(service.getConfigurationsForArtifact(artifactId));
    }

    @RequestMapping(value = "/environments/{environmentId}/configurations",
                    method = RequestMethod.GET)
    public ApiPageResult<Configuration> getConfigurationsForCurrentEnvironment(
            @PathVariable final UUID environmentId)
    {
        return new ApiPageResult<>(service.getConfigurationsForEnvironment(environmentId));
    }

    @RequestMapping(value = "/configurations/{configurationId}", method = RequestMethod.GET)
    public Configuration getConfigurationById(
            @PathVariable("configurationId") final UUID configurationId)
    {
        return getById(configurationId);
    }

    @RequestMapping(value = "/configurations", method = RequestMethod.POST)
    public ResponseEntity<?> createConfiguration(
            @RequestBody final Configuration configuration,
            @PathVariable final UUID artifactId)
    {
        Configuration created = service.create(configuration, artifactId);
        return decorateCreatedEntity(created);
    }

    @RequestMapping(value = "/configurations/{configurationId}",
                    method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEnvironment(
            @PathVariable("configurationId") final UUID configurationId)
    {
        return delete(configurationId);
    }
}
