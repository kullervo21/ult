package com.ultrastyle.projet_ultra.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Configuration de Spring Security pour l'application.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    /**
     * Configuration de l'authentification pour Spring Security.
     *
     * @param auth l'objet AuthenticationManagerBuilder pour la configuration de l'authentification
     * @throws Exception si une erreur survient lors de la configuration de l'authentification
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws  Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource);
    }

    /**
     * Configuration des règles de sécurité pour Spring Security.
     *
     * @param http l'objet HttpSecurity pour la configuration des règles de sécurité
     * @throws Exception si une erreur survient lors de la configuration des règles de sécurité
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/client/{id}/**").access("hasAuthority(#id)")
                .antMatchers("/**").anonymous()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }
}
