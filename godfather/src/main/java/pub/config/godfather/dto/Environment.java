package pub.config.godfather.dto;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by alexandru.ionita on 1/25/15.
 */
public class Environment extends ResourceSupport implements Dto
{

    private String name;
    private int priority;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPriority()
    {
        return priority;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }
}
