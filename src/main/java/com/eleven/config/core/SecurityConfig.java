package com.eleven.config.core;

import com.eleven.handler.CustomSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * Created by User on 2017/11/2.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   /* @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("sysadmin").password("111111").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("jyy").password("111111").roles("USER");
        auth.inMemoryAuthentication().withUser("dba").password("111111").roles("DBA","ADMIN");
    }*/

   @Autowired
   @Qualifier("customUserDetailsService")
   UserDetailsService userDetailsService;


   @Autowired
    CustomSuccessHandler customSuccessHandler;

   @Autowired
    DataSource dataSource;

    //通过Hibernate链接
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    //.csrf() is optional, enabled by default, if using WebSecurityConfigurerAdapter constructor

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/","/home").permitAll()
                .antMatchers("/home").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_DBA')")
                .and()
                .formLogin().loginPage("/login")
                .successHandler(customSuccessHandler)
               // .failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().rememberMe().rememberMeParameter("remember-me")
                .tokenRepository(persistentTokenRepository()).tokenValiditySeconds(86400)
                .userDetailsService(userDetailsService)
                .and()
                //.logout().logoutSuccessUrl("/login?logout")
                //.and()
                .csrf()
                .and()
                .exceptionHandling().accessDeniedPage("/error");
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

   /* <http auto-config="true">
		<intercept-url pattern="/admin**" access="ROLE_ADMIN" />
		<intercept-url pattern="/dba**" access="ROLE_ADMIN,ROLE_DBA" />
	</http>

	<authentication-manager>
	  <authentication-provider>
	    <user-service>
		<user name="yiibai" password="123456" authorities="ROLE_USER" />
		<user name="admin" password="123456" authorities="ROLE_ADMIN" />
		<user name="dba" password="123456" authorities="ROLE_DBA" />
	    </user-service>
	  </authentication-provider>
	</authentication-manager>*/
}
