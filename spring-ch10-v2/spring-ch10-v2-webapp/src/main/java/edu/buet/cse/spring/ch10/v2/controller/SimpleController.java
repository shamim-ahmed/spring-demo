package edu.buet.cse.spring.ch10.v2.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.buet.cse.spring.ch10.v2.model.User;
import edu.buet.cse.spring.ch10.v2.service.ChirperService;

@Controller
public class SimpleController {
  private final ChirperService chirperService;
  
  @Autowired
  public SimpleController(ChirperService chirperService) {
    this.chirperService = chirperService;
  }
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String showHomePage() {
    return "home";
  }
  
  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public String showUserList(ModelMap modelMap) {
    Collection<User> users = chirperService.getUsers(5);
    modelMap.put("users", users);
    
    return "userList";
  }
}
