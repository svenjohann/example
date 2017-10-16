package de.dpd.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;*/

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig { //extends WebSecurityConfigurerAdapter {
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests()
                .antMatchers("/**", "/greeting**").hasRole("USER")
                .anyRequest().authenticated()
              .and()
            .securityContext().securityContextRepository(securityContextRepository());
    }

    @Bean
    public SecurityContextRepository securityContextRepository() {
        return new SecurityContextRepository() {
            @Override
            public SecurityContext loadContext(HttpRequestResponseHolder httpRequestResponseHolder) {
                //String token = httpRequestResponseHolder.getRequest().getHeader("x-token");
                SecurityContext context = new SecurityContextImpl();
                Authentication authentication =
                        new RememberMeAuthenticationToken("key", "example", Arrays.asList(
                                (GrantedAuthority) () -> "ROLE_USER" ));
                context.setAuthentication(authentication);
                return context;
            }

            @Override
            public void saveContext(SecurityContext securityContext, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
            }

            @Override
            public boolean containsContext(HttpServletRequest httpServletRequest) {
                return true;
            }
        };
    }*/
}
