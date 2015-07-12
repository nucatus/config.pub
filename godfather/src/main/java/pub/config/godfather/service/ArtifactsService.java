package pub.config.godfather.service;

import org.springframework.stereotype.Service;
import pub.config.godfather.model.Artifact;

import java.util.Collection;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@Service
public class ArtifactsService
{

    public Artifact createArtifact(Artifact artifact)
    {
        return null;
    }

    public Collection<Artifact> getArtifacts()
    {
        return null;
    }

    public boolean deleteArtifact(Artifact artifact)
    {
        return false;
    }

    public Artifact getById(long id)
    {
        return null;
    }

    public boolean deleteArtifact(long artifactId)
    {
        Artifact artifact = getById(artifactId);
        return deleteArtifact(artifact);
    }
}
