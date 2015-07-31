package pub.config.godfather.dao;

import java.util.UUID;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class UuidHelper
{
    /**
     * Returns the String value of the UUID.
     * @param uuid
     * @return
     * @throws InvalidOrMissingUuid if the uuid is null or invalid
     */
    public static final String getValue(UUID uuid)
    {
        if (uuid == null)
        {
            throw new InvalidOrMissingUuid("ID should not be null nor invalid");
        }
        return uuid.toString();
    }
}
