package pub.config.godfather.dao.user;

import pub.config.godfather.dao.CrudSqlInventory;
import pub.config.godfather.dao.QueryFeeder;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public enum UserSqlInventory implements QueryFeeder, CrudSqlInventory
{
    BASE,
    CREATE_USER,
    DELETE_USER_BY_ID,
    GET_USER_BY_ID,
    LIST_USERS_IN_ORGANIZATION;

    @Override
    public String CREATE()
    {
        return CREATE_USER.getQuery();
    }

    @Override
    public String DELETE()
    {
        return DELETE_USER_BY_ID.getQuery();
    }

    @Override
    public String GET_ALL()
    {
        return LIST_USERS_IN_ORGANIZATION.getQuery();
    }

    @Override
    public String GET_BY_ID()
    {
        return GET_USER_BY_ID.getQuery();
    }
}
