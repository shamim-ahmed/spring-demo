package edu.buet.cse.spring.ch07.v3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.buet.cse.spring.ch07.v3.model.Message;
import edu.buet.cse.spring.ch07.v3.model.User;
import edu.buet.cse.spring.ch07.v3.service.ChirperService;

@Controller
public class ChirperController {
  private final ChirperService chirperService;
  
  @Autowired
  public ChirperController(ChirperService chirperService) {
    this.chirperService = chirperService;
  }
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String showHomePage(ModelMap modelMap) {    
    return "home";
  }
  
  @RequestMapping(value = "/user-list", method = RequestMethod.GET)
  public String showUserList(ModelMap modelMap) {
    List<User> users = chirperService.getUsers();
    modelMap.put("users", users);
    
    return "userList";
  }
  
  @RequestMapping(value = "/message-list", method = RequestMethod.GET)
  public String showMessageList(ModelMap modelMap) {
    List<Message> messages = chirperService.getMessages();
    modelMap.put("messages", messages);
    
    return "messageList";
  }
}
