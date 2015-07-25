package pub.config.godfather.dao.configuration.items;

import pub.config.godfather.dao.CrudSqlInventory;
import pub.config.godfather.dao.QueryFeeder;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public enum ConfigurationItemSqlInventory implements QueryFeeder, CrudSqlInventory
{
    BASE,
    CREATE_CONFIGURATION_ITEM,
    DELETE_CONFIGURATION_ITEM_BY_ID,
    GET_CONFIGURATION_ITEM_BY_ID,
    LIST_CONFIGURATION_ITEMS_FOR_CONFIGURATION;


    @Override
    public String CREATE()
    {
        return CREATE_CONFIGURATION_ITEM.getQuery();
    }

    @Override
    public String DELETE()
    {
        return DELETE_CONFIGURATION_ITEM_BY_ID.getQuery();
    }

    @Override
    public String GET_ALL()
    {
        return null;
    }

    @Override
    public String GET_BY_ID()
    {
        return GET_CONFIGURATION_ITEM_BY_ID.getQuery();
    }
}
