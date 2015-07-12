package pub.config.godfather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.SpringBootRepositoryRestMvcConfiguration;

@SpringBootApplication
public class GodfatherApplication extends SpringBootRepositoryRestMvcConfiguration
{

    public static void main(String[] args) {
        SpringApplication.run(GodfatherApplication.class, args);
    }
}
