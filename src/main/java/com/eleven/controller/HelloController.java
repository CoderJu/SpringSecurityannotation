package com.eleven.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by User on 2017/11/2.
 */
@Controller
public class HelloController {


    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String welcomePage(ModelMap model) {
        model.addAttribute("greeting", "Hi, Welcome to mysite");
        return "welcome";
    }

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String adminPage(ModelMap model){
        model.addAttribute("user",getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/dba", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) {
        model.addAttribute("user",getPrincipal());
        return "dba";
    }

    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String AccessDeniedPage(ModelMap model){
        model.addAttribute("user",getPrincipal());
        return "accessDenied";
    }


    //Spring Security see this :
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String  logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    /**
     *  通过Authentication.getPrincipal()可以获取到代表当前用户的信息，
     *  这个对象通常是UserDetails的实例。获取当前用户的用户名是一种比较常见的需求，
     *  关于上述代码其实Spring Security在Authentication中的实现类中已经为我们做了相关实现，
     *  所以获取当前用户的用户名最简单的方式应当如下。
     *  public String getCurrentUsername() {
     *  return SecurityContextHolder.getContext().getAuthentication().getName();
     *  }
     * @return
     */
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
