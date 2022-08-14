package com.example.onlineshop.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("myuser")
                .password("pass")
                .roles("ADMIN")
                .and()
                .withUser("hermi")
                .password("hermi1234")
                .roles("ADMIN");
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/cloth/men/new").hasAnyRole("ADMIN")
                .antMatchers("/cloth/men/save").hasAnyRole("ADMIN")
                .antMatchers("/cloth/women/new").hasAnyRole("ADMIN")
                .antMatchers("/cloth/women/save").hasAnyRole("ADMIN")
                .antMatchers("/","/**").permitAll()
                .and()
                .formLogin();
    }
}
