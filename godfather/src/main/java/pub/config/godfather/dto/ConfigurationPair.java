package pub.config.godfather.dto;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by alexandru.ionita on 1/25/15.
 */
public class ConfigurationPair extends ResourceSupport implements Dto
{

    private String name;
    private Object value;
    private Class type;
    private String comment;
    private boolean enabled = true;
    private String defaultValue;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

    public Class getType()
    {
        return type;
    }

    public void setType(Class type)
    {
        this.type = type;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    public String getDefaultValue()
    {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue)
    {
        this.defaultValue = defaultValue;
    }
}
