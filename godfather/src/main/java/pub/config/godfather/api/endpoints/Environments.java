package pub.config.godfather.api.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pub.config.godfather.api.util.ApiPageResult;
import pub.config.godfather.model.Environment;
import pub.config.godfather.service.EnvironmentsService;

import java.util.UUID;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@RestController
@RequestMapping("/api/artifacts/{artifactId}/environments")
public class Environments extends BasicEndpoint<Environment, EnvironmentsService>
{

    @Autowired
    public Environments(EnvironmentsService service)
    {
        super(service);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ApiPageResult<Environment> getEnvironmentsForCurrentArtifact(
            @PathVariable final UUID artifactId)
    {
        return new ApiPageResult<>(service.getEnvironmentsForArtifact(artifactId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createEnvironment(
            @RequestBody final Environment environment,
            @PathVariable final UUID artifactId)
    {
        if (artifactId == null)
        {
            throw new IllegalArgumentException("The artifact ID must be non-null and a valid UUID");
        }
        Environment created = service.create(environment, artifactId);
        return decorateCreatedEntity(created);
    }

    @RequestMapping(value = "/{environmentId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEnvironment(
            @PathVariable("environmentId") final UUID environmentId)
    {
        return delete(environmentId);
    }

    @RequestMapping(value = "/{environmentId}", method = RequestMethod.GET)
    public Environment getEnvironmentById(
            @PathVariable("environmentId") final UUID environmentId)
    {
        return getById(environmentId);
    }

}
