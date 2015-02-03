package pub.config.godfather.bootstrap;

import com.mongodb.ServerAddress;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.data.mongodb.config.ServerAddressPropertyEditor;

/**
 * Created by alexandru.ionita on 11/29/14.
 */
public class ServerAddressPropertyEditorRegistrar implements PropertyEditorRegistrar
{
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry)
    {
        registry.registerCustomEditor(ServerAddress[].class, new ServerAddressPropertyEditor());
    }
}
