package pub.config.godfather.api.endpoints;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pub.config.godfather.api.util.ApiPageResult;
import pub.config.godfather.dao.BasicDao;
import pub.config.godfather.model.Artifact;
import pub.config.godfather.model.RootModel;
import pub.config.godfather.service.BasicService;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public abstract class BasicEndpoint<M extends RootModel, T extends BasicService<M, ? extends BasicDao>>
{

    T service;

    public BasicEndpoint(T service)
    {
        this.service = service;
    }

    protected ResponseEntity<?> decorateCreatedEntity(M entity)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getId()).toUri());
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    public ApiPageResult<M> getAll()
    {
        return new ApiPageResult<>(service.getAll());
    }

    public ResponseEntity<?> delete(final long entityId)
    {
        boolean deleted = service.delete(entityId);
        if (deleted)
        {
            return new ResponseEntity<>(null, null, HttpStatus.ACCEPTED);
        }
        throw new InternalServerErrorException("Entity couldn't be deleted");
    }

    public M getById(final long entityId)
    {
        M entity = service.getById(entityId);
        if (entity == null)
        {
            throw new NotFoundException("Entity not found");
        }
        return entity;
    }
}
