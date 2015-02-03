package pub.config.godfather.service;

/**
 * Created by alexandru.ionita on 1/17/15.
 */
public class VersionFormatException extends Exception
{
    public VersionFormatException(String cause)
    {
        super(cause);
    }

    public VersionFormatException(Throwable cause)
    {
        super(cause);
    }
}
