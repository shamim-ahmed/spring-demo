package edu.buet.cse.spring.ch07.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.buet.cse.spring.ch07.v1.model.Message;
import edu.buet.cse.spring.ch07.v1.service.ChirperService;

@Controller
public class HomeController {
  private final ChirperService chirperService;
  
  @Autowired
  public HomeController(ChirperService chirperService) {
    this.chirperService = chirperService;
  }
  
  @RequestMapping(value = "/")
  public String showHomePage(ModelMap modelMap) {
    List<Message> messages = chirperService.getMessages(5);
    modelMap.put("messages", messages);
    
    return "home";
  }
}
