package pub.config.godfather.dao;

import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by alexandru.ionita on 3/1/15.
 */
@Component
public class BeforeSaveListener extends AbstractMongoEventListener
{

    @Autowired
    private Validator validator;

    @Override
    public void onBeforeSave(Object source, DBObject dbo)
    {
        Set<ConstraintViolation<Object>> violations = validator.validate(source);
        if (violations.size() > 0)
        {
            throw new ConstraintViolationException(violations);
        }
    }
}
