package pub.config.godfather.bootstrap;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Arrays;

/**
 * Created by alexandru.ionita on 12/1/14.
 */
@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration
{

    private static final String DB_NAME = "configpubdb";

    @Value("mngo1.int0.gf:27017, mngo2.int0.gf:27017, mngo3.int0.gf:27017")
    private ServerAddress[] serverAddresses;

    @Override
    protected String getDatabaseName()
    {
        return DB_NAME;
    }

    @Override
    public Mongo mongo() throws Exception
    {
        return new MongoClient(Arrays.asList(serverAddresses));
    }

    @Bean
    @Override
    public MongoTemplate mongoTemplate() throws Exception
    {
        return new MongoTemplate(mongo(), getDatabaseName());
    }

    @Bean
    public static CustomEditorConfigurer customEditorConfigurer()
    {
        CustomEditorConfigurer configurer = new CustomEditorConfigurer();
        configurer.setPropertyEditorRegistrars(
                new PropertyEditorRegistrar[]{new ServerAddressPropertyEditorRegistrar()});
        return configurer;
    }
}
