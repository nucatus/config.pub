package pub.config.godfather.api.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
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

    @RequestMapping(method = RequestMethod.GET)
    public ApiPageResult<Artifact> getAllArtifacts()
    {
        return new ApiPageResult<>(artifactsService.getArtifacts());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createArtifact(@RequestBody Artifact artifact)
    {
        Artifact created = artifactsService.createArtifact(artifact);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(created.getId()).toUri());
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{artifactId:\\d+}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteArtifact(@PathVariable("artifactId") final long artifactId)
    {
        boolean deleted = artifactsService.deleteArtifact(artifactId);
        if (deleted)
        {
            return new ResponseEntity<>(null, null, HttpStatus.ACCEPTED);
        }
        throw new InternalServerErrorException("Entity couldn't be deleted");
    }

    @RequestMapping(value = "/{artifactId:\\d+}", method = RequestMethod.GET)
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
