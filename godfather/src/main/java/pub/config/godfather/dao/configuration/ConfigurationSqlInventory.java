package pub.config.godfather.dao.configuration;

import pub.config.godfather.dao.CrudSqlInventory;
import pub.config.godfather.dao.QueryFeeder;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public enum ConfigurationSqlInventory implements QueryFeeder, CrudSqlInventory
{
    BASE,
    CREATE_CONFIGURATION,
    DELETE_CONFIGURATION_BY_ID,
    GET_CONFIGURATION_BY_ID,
    LIST_CONFIGURATIONS_FOR_ARTIFACT,
    LIST_CONFIGURATIONS_FOR_ENVIRONMENT,
    LIST_CONFIGURATIONS_IN_ORGANIZATION;

    @Override
    public String CREATE()
    {
        return CREATE_CONFIGURATION.getQuery();
    }

    @Override
    public String DELETE()
    {
        return DELETE_CONFIGURATION_BY_ID.getQuery();
    }

    @Override
    public String GET_ALL()
    {
        return LIST_CONFIGURATIONS_IN_ORGANIZATION.getQuery();
    }

    @Override
    public String GET_BY_ID()
    {
        return GET_CONFIGURATION_BY_ID.getQuery();
    }
}
