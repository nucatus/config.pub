package pub.config.godfather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.config.godfather.dao.artifact.ArtifactDao;
import pub.config.godfather.model.Artifact;
import pub.config.godfather.model.User;
import pub.config.godfather.security.SecurityHelper;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@Service
public class ArtifactsService extends BasicService<Artifact, ArtifactDao>
{

    @Autowired
    public ArtifactsService(ArtifactDao dao)
    {
        super(dao);
    }

    public Artifact create(Artifact artifact)
    {
        User creator = SecurityHelper.getCurrentLoggedInUser();
        return dao.create(artifact, creator);
    }
}
