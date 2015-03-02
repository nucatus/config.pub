package pub.config.godfather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.SpringBootRepositoryRestMvcConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import pub.config.godfather.rest.validators.ConfigurationSetValidator;

@SpringBootApplication
public class GodfatherApplication extends SpringBootRepositoryRestMvcConfiguration
{
    public static void main(String[] args) {
        SpringApplication.run(GodfatherApplication.class, args);
    }

    @Autowired
    public ConfigurationSetValidator beforeCreateConfigurationSetValidator;

    @Bean
    public ConfigurationSetValidator beforeCreateConfigurationSetValidator()
    {
        return new ConfigurationSetValidator();
    }

    @Override
    protected void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener)
    {
        validatingListener.addValidator("beforeCreate", beforeCreateConfigurationSetValidator);
    }


    @Bean
    LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }
}
