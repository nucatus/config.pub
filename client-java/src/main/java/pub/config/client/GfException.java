package pub.config.client;

/**
 * Created by alexandru.ionita on 3/3/15.
 */
public class GfException extends Exception
{
    public GfException(String message)
    {
        super(message);
    }

    public GfException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public GfException(Throwable cause)
    {
        super(cause);
    }
}
