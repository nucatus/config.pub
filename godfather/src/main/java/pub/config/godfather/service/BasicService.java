package pub.config.godfather.service;

import pub.config.godfather.dao.BasicDao;
import pub.config.godfather.dao.CrudSqlInventory;
import pub.config.godfather.model.RootModel;
import pub.config.godfather.model.User;
import pub.config.godfather.security.SecurityHelper;

import java.util.Collection;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public abstract class BasicService<M extends RootModel, T extends BasicDao<M, ? extends CrudSqlInventory>>
{
    public T dao;

    public BasicService(T dao)
    {
        this.dao = dao;
    }

    public Collection<M> getAll()
    {
        return dao.getAll(
                SecurityHelper.getCurrentLoggedInUser().getOrganization());
    }

    public M getById(Long id)
    {
        return dao.getById(id);
    }

    public boolean delete(M entity)
    {
        return dao.deleteById(entity.getId());
    }

    public boolean delete(Long entityId)
    {
        return dao.deleteById(entityId);
    }
}
