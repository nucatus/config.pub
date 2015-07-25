package pub.config.godfather.processors;

import pub.config.godfather.model.ConfigurationItem;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class ItemProcessor
{
    public static String serialize(ConfigurationItem item)
    {
        if (item.getValue() == null)
        {
            return "";
        }
        switch (item.getType())
        {
            case STRING:
                return (String) item.getValue();
            case DOUBLE:
                return Double.toString((Double) item.getValue());
            case LONG:
                return Long.toString((Long) item.getValue());
            case INTEGER:
                return Integer.toString((Integer) item.getValue());
            case BOOLEAN:
                return Boolean.toString((Boolean) item.getValue());
            default:
                return item.getValue().toString();
        }
    }

    public static ConfigurationItem deserialize(ConfigurationItem prototype)
    {
        ConfigurationItem newItem = new ConfigurationItem();
        newItem.setName(prototype.getName());
        newItem.setId(prototype.getId());
        newItem.setConfigurationId(prototype.getConfigurationId());
        newItem.setType(prototype.getType());
        if (prototype.getValue() == null)
        {
            newItem.setValue(prototype.getType().getDefaultValue());
            return newItem;
        }
        String itemValueAsString = String.valueOf(prototype.getValue());
        switch (prototype.getType())
        {
            case STRING:
                newItem.setValue(itemValueAsString);
                break;
            case DOUBLE:
                newItem.setValue(Double.valueOf(itemValueAsString));
                break;
            case INTEGER:
                newItem.setValue(Integer.valueOf(itemValueAsString));
                break;
            case LONG:
                newItem.setValue(Long.valueOf(itemValueAsString));
                break;
            case BOOLEAN:
                newItem.setValue(Boolean.valueOf(itemValueAsString));
                break;
            default:
                newItem.setValue(prototype.getValue());
        }
        return newItem;
    }
}
