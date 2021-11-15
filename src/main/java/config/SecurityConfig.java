package com.csys.template.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment; 
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.session.web.http.HttpSessionStrategy;

@Configuration
@EnableWebSecurity
@Profile("dev")
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableRedisHttpSession
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    private final Environment env;

    public SecurityConfig(Environment env) {
        this.env = env;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("a").password("a").authorities("template-consolide");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        if (!env.acceptsProfiles("unsecure")) {
//            http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/**").authenticated();
//            http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/**").authenticated();
//            http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/**").authenticated();
//            http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/**").authenticated();
//        }
        http.cors().and().formLogin().loginProcessingUrl("/login").loginPage("/").successHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                    Authentication authentication) throws IOException, ServletException {
                response.setContentType("text/html");
                String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
                response.getWriter().print(sessionId);
            }
        });
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.formLogin().failureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                    AuthenticationException arg2) throws IOException, ServletException {
                response.setStatus(401);
            }
        });
        http.logout().logoutUrl("/logout").logoutSuccessHandler(new LogoutSuccessHandler() {
            @Override
            public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication a) throws IOException, ServletException {
               response.setStatus(200);
            }
        });
        http.requestCache()
                .requestCache(new NullRequestCache());
    }

    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("x-auth-token");
        serializer.setCookiePath("/");
        serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$");
        return serializer;
    }

    @Bean
    HttpSessionStrategy sessionStrategy() {
        return new CustomHeaderHttpSessionStrategy();
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return userDetailsService;
    }

}
