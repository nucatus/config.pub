package pub.config.godfather;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        UserDetailsService userDetails = new InMemoryUserDetailsManager(
                Arrays.<UserDetails>asList(new User("aio_client", "N/A", AuthorityUtils
                        .commaSeparatedStringToAuthorityList("ROLE_USER"))));
        http.authorizeRequests().anyRequest().authenticated().and().x509()
                .userDetailsService(userDetails).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.NEVER).and().csrf()
                .disable();
    }
}
