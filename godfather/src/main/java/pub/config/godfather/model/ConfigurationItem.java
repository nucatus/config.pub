package pub.config.godfather.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class ConfigurationItem extends RootModel
{
    private String name;
    private Object value;
    private ItemType type;
    private UUID configurationId;
    private String comment;

    public ConfigurationItem()
    {

    }

    public ConfigurationItem(ConfigurationItem another)
    {
        this.name = another.getName();
        this.value = another.getValue();
        this.type = another.getType();
        this.configurationId = another.getConfigurationId();
        this.comment = another.getComment();
    }

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

    public ItemType getType()
    {
        return type;
    }

    public void setType(ItemType type)
    {
        this.type = type;
    }

    public UUID getConfigurationId()
    {
        return configurationId;
    }

    public void setConfigurationId(UUID configurationId)
    {
        this.configurationId = configurationId;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public enum ItemType
    {
        STRING(0, ""), LONG(1, 0L), DOUBLE(2, 0.0), INTEGER(3, 0), BOOLEAN(4, Boolean.FALSE);

        private int id;
        private Object defaultValue;

        private static Map<Integer, ItemType> lookup = new HashMap<>();
        static
        {
            for (ItemType type : ItemType.values())
            {
                lookup.put(type.getId(), type);
            }
        }

        ItemType(int id, Object defaultValue)
        {
            this.id = id;
            this.defaultValue = defaultValue;
        }

        public static ItemType getById(int id)
        {
            return lookup.get(id);
        }

        public int getId()
        {
            return id;
        }

        public Object getDefaultValue()
        {
            return defaultValue;
        }
    }
}
