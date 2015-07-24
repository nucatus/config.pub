package pub.config.godfather.dao.environment;

import pub.config.godfather.dao.CrudSqlInventory;
import pub.config.godfather.dao.QueryFeeder;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public enum EnvironmentSqlInventory implements QueryFeeder, CrudSqlInventory
{
    BASE,
    CREATE_ENVIRONMENT,
    DELETE_ENVIRONMENT_BY_ID,
    LIST_ENVIRONMENTS_IN_ORGANIZATION,
    LIST_ENVIRONMENTS_FOR_ARTIFACT,
    GET_ENVIRONMENT_BY_ID;

    @Override
    public String CREATE()
    {
        return CREATE_ENVIRONMENT.getQuery();
    }

    @Override
    public String DELETE()
    {
        return DELETE_ENVIRONMENT_BY_ID.getQuery();
    }

    @Override
    public String GET_ALL()
    {
        return LIST_ENVIRONMENTS_IN_ORGANIZATION.getQuery();
    }

    @Override
    public String GET_BY_ID()
    {
        return GET_ENVIRONMENT_BY_ID.getQuery();
    }


}
