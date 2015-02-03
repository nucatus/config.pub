package pub.config.godfather.domain;

import java.util.HashMap;

/**
 * Created by alexandru.ionita on 1/17/15.
 */
public enum Environment
{

    DEV("Dev", 10), INTEGRATION("Integration", 100), QA("QA", 200), PRODUCTION("Production", 1000);

    private String name;
    private int priority;
    private static HashMap<String, Environment> lookup = new HashMap<>();

    static
    {
        for (Environment env : Environment.values())
        {
            lookup.put(env.getName().toLowerCase(), env);
        }
    }

    private Environment(String name, int priority)
    {
        this.name = name;
        this.priority = priority;
    }

    public static Environment getByName(String name)
    {
        return lookup.get(name.toLowerCase());
    }

    public String getName()
    {
        return name;
    }

    public int getPriority()
    {
        return priority;
    }
}
