package edu.buet.cse.spring.ch11.v1.controller;

import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.buet.cse.spring.ch11.v1.model.Message;
import edu.buet.cse.spring.ch11.v1.model.User;
import edu.buet.cse.spring.ch11.v1.service.ChirperService;

@Controller
public class SimpleController {
  private static final int MAX_USER_COUNT = 5;
  
  private final Logger logger = LogManager.getLogger(getClass()); 
  private final ChirperService chirperService;
  
  @Autowired
  public SimpleController(ChirperService chirperService) {
    this.chirperService = chirperService;
  }
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String showHome() {
    return "home";
  }
  
  @RequestMapping(value = "/user-form", method = RequestMethod.GET)
  public String showUserForm() {
    return "userForm";
  }
  
  @RequestMapping(value = "/message-form", method = RequestMethod.GET)
  public String showMessageForm() {
    return "messageForm";
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
    modelMap.put("userId", message.getUserId());
    
    return "message";
  }
  
  @RequestMapping(value = "/user/{userId}/messages", method = RequestMethod.GET)
  public String showMessageList(@PathVariable Long userId, ModelMap modelMap) {
    Collection<Message> messages = chirperService.getMessagesByUserId(userId);
    modelMap.put("messages", messages);
    
    return "messageList";
  }
  
  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public String createUser(@RequestParam String username, @RequestParam String password, @RequestParam Boolean receiveEmail, ModelMap modelMap) {    
    if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
      modelMap.put("message", "Username and password must be provided");
      return "resultPage";
    }
    
    if (receiveEmail == null) {
      receiveEmail = Boolean.FALSE;
    }
    
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    user.setJoinDate(new Date());
    user.setReceiveEmail(receiveEmail);
    
    boolean result = false;

    try {
      result = chirperService.addUser(user);
    } catch (Exception ex) {
      logger.error(ex);
    }
    
    if (result) {
      modelMap.put("message", "The user was created successfully");
    } else {
      modelMap.put("message", "An error occurred while creating the user");
    }
    
    return "resultPage";
  }
  
  @RequestMapping(value = "/message", method = RequestMethod.POST)
  public String createMessage(@RequestParam String content, @RequestParam Long userId, ModelMap modelMap) {
    if (StringUtils.isBlank(content) || userId == null) {
      modelMap.put("error", "message content and user id must be provided");
      return "resultPage";
    }
    
    Message message = new Message();
    message.setContent(content);
    message.setUserId(userId);
    message.setCreationDate(new Date());
    
    boolean result = false;
    
    try {
      result = chirperService.addMessage(message);
    } catch (Exception ex) {
      logger.error(ex);
    }
    
    if (result) {
      modelMap.put("message", "The message was created successfully");
    } else {
      modelMap.put("message", "An error occurred while creating the message");
    }
    
    return "resultPage";
  }
}
