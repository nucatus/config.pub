package pub.config.godfather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.config.godfather.model.Artifact;
import pub.config.godfather.model.Environment;

import java.util.Collection;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@Service
public class EnvironmentsService
{

    @Autowired
    ArtifactsService artifactsService;

    public Environment createForArtifact(Environment environment, Artifact parent)
    {
        return null;
    }

    public Environment createForArtifact(Environment environment, long artifactId)
    {
        Artifact artifact = artifactsService.getById(artifactId);
        return createForArtifact(environment, artifact);
    }

    public Collection<Environment> getByArtifact(Artifact artifact)
    {
        return null;
    }

    public boolean delete(Environment environment)
    {
        return false;
    }

    public boolean delete(long environmentId)
    {
        Environment environment = getById(environmentId);
        return delete(environment);
    }

    public Environment getById(long environmentId)
    {
        return null;
    }
}
