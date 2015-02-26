package pub.config.godfather.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pub.config.godfather.domain.ConfigurationSet;

/**
 * Created by alexandru.ionita on 2/15/15.
 */
@RepositoryRestResource(collectionResourceRel = "configuration", path = "configuration")
public interface ConfigurationRepository extends PagingAndSortingRepository<ConfigurationSet, String>
{
}
