package pub.config.godfather.api.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pub.config.godfather.api.util.ApiPageResult;
import pub.config.godfather.model.User;
import pub.config.godfather.service.UsersService;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@RestController
@RequestMapping("/api/users")
public class Users extends BasicEndpoint<User, UsersService>
{

    @Autowired
    public Users(UsersService service)
    {
        super(service);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ApiPageResult<User> getUsersForCurrentAccount()
    {
        return new ApiPageResult<>(service.getUsersForCurrentAccount());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createUser(
            @RequestBody final User user)
    {
        User created = service.create(user);
        return decorateCreatedEntity(created);
    }

    @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(
            @PathVariable("userId") final long userId)
    {
        return delete(userId);
    }

    @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.GET)
    public User getUserById(
            @PathVariable("userId") final long userId)
    {
        return getById(userId);
    }

}
