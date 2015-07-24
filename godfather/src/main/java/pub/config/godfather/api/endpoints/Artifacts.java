package pub.config.godfather.api.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pub.config.godfather.api.util.ApiPageResult;
import pub.config.godfather.model.Artifact;
import pub.config.godfather.service.ArtifactsService;

import javax.ws.rs.*;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@RestController
@RequestMapping("/api/artifacts")
public class Artifacts extends BasicEndpoint<Artifact, ArtifactsService>
{

    @Autowired
    public Artifacts(ArtifactsService service)
    {
        super(service);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ApiPageResult<Artifact> getAllArtifacts()
    {
        return super.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createArtifact(@RequestBody Artifact artifact)
    {
        Artifact created = service.create(artifact);
        return decorateCreatedEntity(created);
    }

    @RequestMapping(value = "/{artifactId:\\d+}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteArtifact(@PathVariable("artifactId") final long artifactId)
    {
        return super.delete(artifactId);
    }

    @RequestMapping(value = "/{artifactId:\\d+}", method = RequestMethod.GET)
    public Artifact getArtifactById(@PathVariable("artifactId") final long artifactId)
    {
        return super.getById(artifactId);
    }

}
