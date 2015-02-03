package pub.config.godfather.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pub.config.godfather.domain.ConfigurationSet;
import pub.config.godfather.dto.Configuration;
import pub.config.godfather.service.ConfigurationException;
import pub.config.godfather.service.ConfigurationQueryService;

/**
 * Created by alexandru.ionita on 1/17/15.
 */

@RestController
@RequestMapping("/api")
public class ConfigurationResource
{

    @Autowired
    ConfigurationQueryService configQueryService;


    /**
     * Query for a configuration set based on the component name, its version and environment
     * parameters.
     * @param component
     * @param version
     * @param environment
     * @return
     * @throws ConfigurationException
     */
    @RequestMapping(value = "/{component}/")
    public @ResponseBody
    ResponseEntity<Configuration> getConfiguration(
            @PathVariable("component") String component,
            @RequestParam("version") String version,
            @RequestParam("env") String environment) throws ConfigurationException
    {
        ConfigurationSet config = configQueryService.getConfiguration(component, version, environment);
        return new ResponseEntity<>(config.toDto(), HttpStatus.FOUND);
    }

    @ExceptionHandler(ConfigurationException.class)
    ResponseEntity<String> handleConfigurationException(Exception e)
    {
        return new ResponseEntity<>(
                String.format("{\"reason\":\"%s\"}", e.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

}
