package pub.config.client.model;

import java.util.Collection;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class Listing<T>
{
    private Collection<T> data;
    private int count;

    public Collection<T> getData()
    {
        return data;
    }

    public void setData(Collection<T> data)
    {
        this.data = data;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }
}
