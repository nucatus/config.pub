package pub.config.godfather.api.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pub.config.godfather.api.util.ApiPageResult;
import pub.config.godfather.model.Configuration;
import pub.config.godfather.model.Environment;
import pub.config.godfather.service.ConfigurationsService;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@RestController
@RequestMapping("/api/artifacts/{artifactId:\\d+}")
public class Configurations extends BasicEndpoint<Configuration, ConfigurationsService>
{
    @Autowired
    public Configurations(ConfigurationsService service)
    {
        super(service);
    }

    @RequestMapping(value = "/configurations", method = RequestMethod.GET)
    public ApiPageResult<Configuration> getConfigurationsForCurrentArtifact(
            @PathVariable final Long artifactId)
    {
        return new ApiPageResult<>(service.getConfigurationsForArtifact(artifactId));
    }

    @RequestMapping(value = "/environments/{environmentId:\\d+}/configurations",
                    method = RequestMethod.GET)
    public ApiPageResult<Configuration> getConfigurationsForCurrentEnvironment(
            @PathVariable final Long environmentId)
    {
        return new ApiPageResult<>(service.getConfigurationsForEnvironment(environmentId));
    }

    @RequestMapping(value = "/configurations/{configurationId:\\d+}", method = RequestMethod.GET)
    public Configuration getConfigurationById(
            @PathVariable("configurationId") final long configurationId)
    {
        return getById(configurationId);
    }

    @RequestMapping(value = "/configurations", method = RequestMethod.POST)
    public ResponseEntity<?> createConfiguration(
            @RequestBody final Configuration configuration,
            @PathVariable final Long artifactId)
    {
        Configuration created = service.create(configuration, artifactId);
        return decorateCreatedEntity(created);
    }

    @RequestMapping(value = "/configurations/{configurationId:\\d+}",
                    method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEnvironment(
            @PathVariable("configurationId") final long configurationId)
    {
        return delete(configurationId);
    }
}
