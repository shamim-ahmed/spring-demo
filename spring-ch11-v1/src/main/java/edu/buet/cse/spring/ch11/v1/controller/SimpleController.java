package edu.buet.cse.spring.ch11.v1.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.buet.cse.spring.ch11.v1.model.Message;
import edu.buet.cse.spring.ch11.v1.model.User;
import edu.buet.cse.spring.ch11.v1.service.ChirperService;

@Controller
public class SimpleController {
  private static final int MAX_USER_COUNT = 5;
  
  private final ChirperService chirperService;
  
  @Autowired
  public SimpleController(ChirperService chirperService) {
    this.chirperService = chirperService;
  }
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String showHome() {
    return "home";
  }
  
  @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
  public String showUser(@PathVariable Long id, ModelMap modelMap) {
    User user = chirperService.getUser(id);
    modelMap.put("user", user);
    
    return "user";
  }
  
  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public String showUserList(ModelMap modelMap) {
    Collection<User> users = chirperService.getUsers(MAX_USER_COUNT);
    modelMap.put("users", users);
    
    return "userList";
  }
 
  @RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
  public String showMessage(@PathVariable Long id, ModelMap modelMap) {
    Message message = chirperService.getMessage(id);
    modelMap.put("message", message);
    
    return "message";
  }
}
