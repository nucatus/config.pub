package pub.config.godfather.domain;

import java.util.Date;

/**
 * Created by alexandru.ionita on 1/16/15.
 */
public enum ConfigValueType
{
    STRING(String.class),
    INTEGER(Integer.class),
    DATE(Date.class);

    private Class type;

    private ConfigValueType(Class type)
    {
        this.type = type;
    }
}
