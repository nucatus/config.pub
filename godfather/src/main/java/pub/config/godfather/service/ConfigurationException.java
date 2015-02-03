package pub.config.godfather.service;

/**
 * Created by alexandru.ionita on 1/17/15.
 */
public class ConfigurationException extends Throwable
{
    public ConfigurationException(Exception e)
    {
        super(e);
    }

    public ConfigurationException(String message)
    {
        super(message);
    }
}
