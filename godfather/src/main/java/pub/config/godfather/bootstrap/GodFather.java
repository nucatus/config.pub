package pub.config.godfather.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("pub.config")
public class GodFather
{

    public static void main(String[] args) {
        SpringApplication.run(GodFather.class, args);
    }
}
