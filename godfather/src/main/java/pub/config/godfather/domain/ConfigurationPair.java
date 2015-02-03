package pub.config.godfather.domain;

import java.util.Set;

/**
 * Created by alexandru.ionita on 1/16/15.
 */
public class ConfigurationPair
{

    private String name;
    private Object value;
    private ConfigValueType type;
    private String comment;
    private boolean enabled;
    private Set<ActionHistory> history;
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

    public ConfigValueType getType()
    {
        return type;
    }

    public void setType(ConfigValueType type)
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
}
