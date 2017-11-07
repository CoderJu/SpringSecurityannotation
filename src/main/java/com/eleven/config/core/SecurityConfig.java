package com.eleven.config.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by User on 2017/11/2.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("sysadmin").password("111111").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("jyy").password("jyy").roles("USER");
        auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
                .and().formLogin();
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
