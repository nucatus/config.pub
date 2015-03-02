package pub.config.godfather.rest.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pub.config.godfather.domain.ConfigurationSet;

/**
 * Created by alexandru.ionita on 3/1/15.
 */
public class ConfigurationSetValidator implements Validator
{
    @Override
    public boolean supports(Class<?> clazz)
    {
        return clazz != null && clazz == ConfigurationSet.class ;
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        assert(target instanceof ConfigurationSet);
        ConfigurationSet configuration = (ConfigurationSet) target;
        /*if (configuration.getOwner() == null)
        {
            errors.reject("Configuration owner is mandatory");
        }*/
    }
}
