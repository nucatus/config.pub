package pub.config.godfather.api.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pub.config.godfather.model.Environment;
import pub.config.godfather.service.EnvironmentsService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@RestController
@RequestMapping("/api/artifacts/{artifactId:\\d+}/environments")
public class Environments
{

    @Autowired
    EnvironmentsService envService;

    @POST
    public Response createEnvironment(Environment environment,
                                      @PathVariable("artifactId") final long artifactId)
    {
        Environment created = envService.createForArtifact(environment, artifactId);
        if (created != null && created.getId() != null)
        {
            //  TODO: check the utility of the UriBuilder construction
            URI createdId = UriBuilder.fromResource(Environment.class).build(null);
            return Response.created(createdId).build();
        }
        throw new InternalServerErrorException("Entity couldn't be created");
    }

    @DELETE
    @RequestMapping("/{environmentId:\\d+}")
    public Response deleteArtifact(@PathVariable("environmentId") final long environmentId)
    {
        boolean deleted = envService.delete(environmentId);
        if (deleted)
        {
            return Response.accepted().build();
        }
        throw new InternalServerErrorException("Entity couldn't be deleted");
    }

    @GET
    @RequestMapping("/{environmentId:\\d+}")
    public Environment getEnvironment(@PathVariable("environmentId") final long environmentId)
    {
        Environment environment = envService.getById(environmentId);
        if (environment == null)
        {
            throw new NotFoundException("Entity not found");
        }
        return environment;
    }
}
