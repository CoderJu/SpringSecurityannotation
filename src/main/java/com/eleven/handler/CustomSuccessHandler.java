package com.eleven.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by User on 2017/11/28.
 */
@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            System.out.println("Can't redirect");
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);

    }

    private String determineTargetUrl(Authentication authentication) {
        String url = "";
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<String>();
        for (GrantedAuthority a: authorities ) {
            roles.add(a.getAuthority());
        }
        if (isDba(roles)){
            System.out.println(">>>>>>>"+roles);
            url = "/dba";
        }else if (isUser(roles)){
            url = "/home";
        }else if (isAdmin(roles)){
            url = "/admin";
        }else {
            url="/error";
        }
        return url;
    }

    @Override
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    @Override
    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    private  boolean isDba(List<String> roles){
        if (roles.contains("ROLE_DBA")){
            return true;
        }
        return false;
    }

    private  boolean isUser(List<String> roles){
        if (roles.contains("ROLE_USER")){
            return true;
        }
        return false;
    }

    private  boolean isAdmin(List<String> roles){
        if (roles.contains("ROLE_ADMIN")){
            return true;
        }
        return false;
    }
}
