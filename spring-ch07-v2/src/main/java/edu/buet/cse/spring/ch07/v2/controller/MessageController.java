package edu.buet.cse.spring.ch07.v2.controller;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.buet.cse.spring.ch07.v2.model.Message;
import edu.buet.cse.spring.ch07.v2.service.ChirperService;

@Controller
public class MessageController {
  private final ChirperService chirperService;
  
  @Autowired
  public MessageController(ChirperService chirperService) {
    this.chirperService = chirperService;
  }
  
  @RequestMapping(value = "/message-form", method = RequestMethod.GET)
  public String showMessageForm() {
    return "message/messageForm";
  }
  
  @RequestMapping(value = "/create-message", method = RequestMethod.POST)
  public String createMessage(@RequestParam String content, @RequestParam Long userId) {
    if (StringUtils.isBlank(content)) {
      return "message/error";
    }
    
    Message message = new Message();
    message.setContent(content);
    message.setCreationDate(new Date());
    message.setUser(chirperService.getUser(userId));
    boolean result = chirperService.addMessage(message);
    
    return result ? "message/success" : "message/error";
  }
}
