package pub.config.godfather;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@Configuration
public class WebMvcConfig extends WebMvcAutoConfiguration.EnableWebMvcConfiguration
{
    @Override
    protected void configureContentNegotiation(ContentNegotiationConfigurer configurer)
    {
        configurer.favorPathExtension(false).
                favorParameter(true).
                parameterName("mediaType").
                ignoreAcceptHeader(true).
                useJaf(false).
                defaultContentType(MediaType.APPLICATION_JSON).
                mediaType("text", MediaType.TEXT_PLAIN).
                mediaType("json", MediaType.APPLICATION_JSON);
    }

    @Override
    protected void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/login").setViewName("login");
    }
}
