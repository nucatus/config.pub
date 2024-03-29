package pub.config.godfather.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class Environment extends RootModel
{

    private EnvironmentType type;
    private String name;

    public EnvironmentType getType()
    {
        return type;
    }

    public void setType(EnvironmentType type)
    {
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public enum EnvironmentType
    {
        DEV(10), STAGING(40), QA(110), PROD(299);

        private int id;
        private static Map<Integer, EnvironmentType> lookUp = new HashMap<>();

        static
        {
            for (EnvironmentType type : EnvironmentType.values())
            {
                lookUp.put(type.getId(), type);
            }
        }

        EnvironmentType(int id)
        {
            this.id = id;
        }

        public int getId()
        {
            return id;
        }

        public static EnvironmentType getById(int id)
        {
            return lookUp.get(id);
        }
    }
}
