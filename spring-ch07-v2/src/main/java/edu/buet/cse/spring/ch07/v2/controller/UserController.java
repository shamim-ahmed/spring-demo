package edu.buet.cse.spring.ch07.v2.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.buet.cse.spring.ch07.v2.model.User;
import edu.buet.cse.spring.ch07.v2.service.ChirperService;
import edu.buet.cse.spring.ch07.v2.util.AttributeNames;

@Controller
public class UserController {
  private final ChirperService chirperService;
  
  @Autowired
  public UserController(ChirperService chirperService) {
    this.chirperService = chirperService;
  }
  
  @RequestMapping(value = "/login-form", method = RequestMethod.GET)
  public String showLoginForm() {
    return "loginForm";
  }
  
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
    User user = chirperService.getUser(username);
    
    if (user != null && user.getPassword().equalsIgnoreCase(password)) {
      session.setAttribute(AttributeNames.USER_ATTRIBUTE_NAME, user);
      return "loginSuccess";
    }
    
    return "loginError";
  }
  
  @RequestMapping(value = "/register-form", method = RequestMethod.GET)
  public String registerForm() {
    return "registrationForm";
  }
  
  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String register(@RequestParam String username, @RequestParam String password, @RequestParam(required = false) String receiveEmail) {
    if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
      return "registrationError";
    }
    
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    user.setJoinDate(new Date());
    
    user.setReceiveEmail(receiveEmail != null ? Boolean.TRUE : Boolean.FALSE);
    boolean result = chirperService.addUser(user);
    
    return result ? "registrationSuccess" : "registrationError";
  }
  
  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logout(HttpSession session) {
    session.removeAttribute(AttributeNames.USER_ATTRIBUTE_NAME);
    
    return "logoutRedirect";
  }
}
