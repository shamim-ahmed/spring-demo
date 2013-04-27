package edu.buet.cse.spring.ch07.v3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.buet.cse.spring.ch07.v3.model.User;
import edu.buet.cse.spring.ch07.v3.service.UserService;

@Controller
public class HomeController {
  private final UserService userService;
  
  @Autowired
  public HomeController(UserService userService) {
    this.userService = userService;
  }
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String showHomePage(ModelMap modelMap) {
    List<User> users = userService.getUsers();
    modelMap.put("users", users);
    
    return "home";
  }
}
