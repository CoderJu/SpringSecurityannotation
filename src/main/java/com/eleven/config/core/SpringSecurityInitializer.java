package com.eleven.config.core;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by User on 2017/11/5.
 */
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
}


/*
 web.xml
<filter>
<filter-name>springSecurityFilterChain</filter-name>
<filter-class>org.springframework.web.filter.DelegatingFilterProxy
</filter-class>
</filter>

<filter-mapping>
<filter-name>springSecurityFilterChain</filter-name>
<url-pattern>*/
/*</url-pattern>
	</filter-mapping>*/
