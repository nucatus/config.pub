package pub.config.godfather.model;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class ConfigurationItem extends RootModel
{
    private String name;
    private Object value;
    private ItemType type;


    public enum ItemType
    {
        STRING, DATE, LONG, DOUBLE;
    }
}
