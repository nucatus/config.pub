package pub.config.godfather.dao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public interface QueryFeeder
{
    default String getQuery()
    {
        try
        {
            String name = ((Enum)this).name().toLowerCase();
            Path path = Paths.get(this.getClass().getResource(name + ".sql").toURI());
            byte[] content = Files.readAllBytes(path);
            return new String(content, "UTF-8");
        } catch (URISyntaxException | IOException e)
        {
            throw new IllegalStateException("Couldn't read sql query", e);
        }
    }
}
