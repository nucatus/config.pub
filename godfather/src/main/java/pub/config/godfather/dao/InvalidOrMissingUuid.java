package pub.config.godfather.dao;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class InvalidOrMissingUuid extends RuntimeException
{
    public InvalidOrMissingUuid(String s)
    {
        super(s);
    }
}
