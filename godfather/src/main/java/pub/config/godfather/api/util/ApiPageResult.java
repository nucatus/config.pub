package pub.config.godfather.api.util;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class ApiPageResult<T>
{
    private Collection<T> data;
    private int count;

    public ApiPageResult(Collection<T> data)
    {
        this.data = data == null ? new HashSet<>() : data;
        this.count = data == null ? 0 : data.size();
    }

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
