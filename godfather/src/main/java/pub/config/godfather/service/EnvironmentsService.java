package pub.config.godfather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.config.godfather.dao.artifact.ArtifactDao;
import pub.config.godfather.dao.environment.EnvironmentDao;
import pub.config.godfather.model.Artifact;
import pub.config.godfather.model.Environment;
import pub.config.godfather.model.User;
import pub.config.godfather.security.SecurityHelper;

import java.util.Collection;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@Service
public class EnvironmentsService extends BasicService<Environment, EnvironmentDao>
{

    @Autowired
    public EnvironmentsService(EnvironmentDao dao)
    {
        super(dao);
    }

    public Environment create(
            Environment entity,
            Long artifactId)
    {
        User creator = SecurityHelper.getCurrentLoggedInUser();
        return dao.create(entity, creator, artifactId);
    }

    public Collection<Environment> getEnvironmentsForArtifact(Long artifactId)
    {
        return dao.getEnvironmentsForArtifact(artifactId);
    }
}

