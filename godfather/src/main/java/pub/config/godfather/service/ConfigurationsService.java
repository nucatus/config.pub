package pub.config.godfather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.config.godfather.dao.configuration.ConfigurationDao;
import pub.config.godfather.model.Configuration;
import pub.config.godfather.model.User;
import pub.config.godfather.security.SecurityHelper;

import java.util.Collection;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@Service
public class ConfigurationsService extends BasicService<Configuration, ConfigurationDao>
{

    @Autowired
    public ConfigurationsService(ConfigurationDao dao)
    {
        super(dao);
    }

    public Configuration create(
            Configuration entity,
            Long artifactId)
    {
        User creator = SecurityHelper.getCurrentLoggedInUser();
        return dao.create(entity, creator, artifactId);
    }


    public Collection<Configuration> getConfigurationsForArtifact(Long artifactId)
    {
        return dao.getConfigurationsForArtifact(artifactId);
    }

    public Collection<Configuration> getConfigurationsForEnvironment(Long environment)
    {
        return dao.getConfigurationsForEnvironment(environment);
    }
}
