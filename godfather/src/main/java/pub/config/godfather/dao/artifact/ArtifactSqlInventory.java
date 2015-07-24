package pub.config.godfather.dao.artifact;

import pub.config.godfather.dao.CrudSqlInventory;
import pub.config.godfather.dao.QueryFeeder;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public enum ArtifactSqlInventory implements QueryFeeder, CrudSqlInventory
{
    BASE,
    GET_ARTIFACT_BY_ID,
    LIST_ARTIFACTS_IN_ORGANIZATION,
    DELETE_ARTIFACT_BY_ID,
    CREATE_ARTIFACT;

    @Override
    public String CREATE()
    {
        return CREATE_ARTIFACT.getQuery();
    }

    @Override
    public String DELETE()
    {
        return DELETE_ARTIFACT_BY_ID.getQuery();
    }

    @Override
    public String GET_ALL()
    {
        return LIST_ARTIFACTS_IN_ORGANIZATION.getQuery();
    }

    @Override
    public String GET_BY_ID()
    {
        return GET_ARTIFACT_BY_ID.getQuery();
    }


}
