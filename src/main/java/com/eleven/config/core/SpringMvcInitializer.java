package com.eleven.config.core;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by User on 2017/11/5.
 */
public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return  null;
    }
    @Override
    protected String[] getServletMappings() {
         return new String[] { "/" };
    }
}
