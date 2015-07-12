package pub.config.godfather.api.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pub.config.godfather.api.util.ApiPageResult;
import pub.config.godfather.model.Artifact;
import pub.config.godfather.service.ArtifactsService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Collection;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@RestController
@RequestMapping("/api/artifacts")
public class Artifacts
{

    @Autowired
    ArtifactsService artifactsService;

    @GET
    public ApiPageResult<Artifact> getAllArtifacts()
    {
        return new ApiPageResult<>(artifactsService.getArtifacts());
    }

    @POST
    public Response createArtifact(Artifact artifact)
    {
        Artifact created = artifactsService.createArtifact(artifact);
        if (created != null && created.getId() != null)
        {
            //  TODO: check the utility of the UriBuilder construction
            URI createdId = UriBuilder.fromResource(Artifact.class).build(null);
            return Response.created(createdId).build();
        }
        throw new InternalServerErrorException("Entity couldn't be created");
    }

    @DELETE
    @RequestMapping("/{artifactId:\\d+}")
    public Response deleteArtifact(@PathVariable("artifactId") final long artifactId)
    {
        boolean deleted = artifactsService.deleteArtifact(artifactId);
        if (deleted)
        {
            return Response.accepted().build();
        }
        throw new InternalServerErrorException("Entity couldn't be deleted");
    }

    @GET
    @RequestMapping("/{artifactId:\\d+}")
    public Artifact getArtifactById(@PathVariable("artifactId") final long artifactId)
    {
        Artifact artifact = artifactsService.getById(artifactId);
        if (artifact == null)
        {
            throw new NotFoundException("Entity not found");
        }
        return artifact;
    }

}
