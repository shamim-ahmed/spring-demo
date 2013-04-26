package edu.buet.cse.spring.ch07.v1.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.buet.cse.spring.ch07.v1.model.Message;
import edu.buet.cse.spring.ch07.v1.model.User;
import edu.buet.cse.spring.ch07.v1.service.ChirperService;
import edu.buet.cse.spring.ch07.v1.util.AttributeNames;

@Controller
public class HomeController {
  private static final int MAX_MESSAGE_COUNT = 5;
  private final ChirperService chirperService;
  
  @Autowired
  public HomeController(ChirperService chirperService) {
    this.chirperService = chirperService;
  }
  
  @RequestMapping(value = "/")
  public String showHomePage(HttpSession session, ModelMap modelMap) {
    User user = (User) session.getAttribute(AttributeNames.USER_ATTRIBUTE_NAME);
    List<Message> messages = Collections.emptyList();
    
    if (user != null) {
      messages = chirperService.getMessagesFromUser(user.getId(), MAX_MESSAGE_COUNT);
    } else {
      messages = chirperService.getMessages(MAX_MESSAGE_COUNT);
    }
    
    modelMap.put("messages", messages);
    
    return user != null ? "home/custom" : "home/generic";
  }
}
