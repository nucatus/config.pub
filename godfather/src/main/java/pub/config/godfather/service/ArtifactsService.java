package pub.config.godfather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.config.godfather.dao.artifact.ArtifactDao;
import pub.config.godfather.model.Artifact;

import java.util.Collection;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@Service
public class ArtifactsService
{

    @Autowired
    ArtifactDao artifactDao;


    public Artifact createArtifact(Artifact artifact)
    {
        //  TODO: implement a call to retrieve the current user (caller).
        return artifactDao.create(artifact, 1L);
    }

    public Collection<Artifact> getArtifacts()
    {
        return null;
    }

    public boolean deleteArtifact(Artifact artifact)
    {
        return artifactDao.deleteArtifactById(artifact.getId());
    }

    public Artifact getById(Long id)
    {
        return artifactDao.getArtifactById(id);
    }

    public boolean deleteArtifact(Long artifactId)
    {
        Artifact artifact = getById(artifactId);
        return deleteArtifact(artifact);
    }
}
