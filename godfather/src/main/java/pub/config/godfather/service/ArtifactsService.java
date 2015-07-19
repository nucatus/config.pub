package pub.config.godfather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.config.godfather.dao.artifact.ArtifactDao;
import pub.config.godfather.model.Artifact;
import pub.config.godfather.security.SecurityHelper;

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
        return artifactDao.create(artifact, SecurityHelper.getCurrentLoggedInUser());
    }

    public Collection<Artifact> getArtifacts()
    {
        return artifactDao.getAll(
                SecurityHelper.getCurrentLoggedInUser().getOrganization().getId());
    }

    public boolean deleteArtifact(Artifact artifact)
    {
        return artifactDao.deleteById(artifact.getId());
    }

    public Artifact getById(Long id)
    {
        return artifactDao.getById(id);
    }

    public boolean deleteArtifact(Long artifactId)
    {
        Artifact artifact = getById(artifactId);
        return deleteArtifact(artifact);
    }
}
