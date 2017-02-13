
package com.sage.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    ((HttpSecurity)((HttpSecurity)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)
            /*csrf temporarily disabled */
            http.csrf().disable().authorizeRequests().requestMatchers(new RegexRequestMatcher(".*/site/.*", "GET"),
                    new RegexRequestMatcher(".*/site/.*", "POST"))).authenticated().and()).formLogin().and()).httpBasic();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
            .withUser("user").password("password").roles("USER");
  }
}
