package edu.buet.cse.spring.ch11.v2.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.buet.cse.spring.ch11.v2.model.Message;
import edu.buet.cse.spring.ch11.v2.model.User;
import edu.buet.cse.spring.ch11.v2.service.ChirperService;

@Controller
public class ChirperController {
  private static final int MAX_USER_COUNT = 5;
  private static final String DATE_FORMAT = "yyyy-MM-dd";
  
  private final Logger logger = LogManager.getLogger(getClass()); 
  private final ChirperService chirperService;
  
  @Autowired
  public ChirperController(ChirperService chirperService) {
    this.chirperService = chirperService;
  }
  
  @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, headers = {"Accept=text/xml, application/json, text/html"})
  public @ResponseBody User showUser(@PathVariable Long id) {
    return chirperService.getUser(id);
  }
  
  @RequestMapping(value = "/users", method = RequestMethod.GET, headers = {"Accept=text/xml, application/json"})
  public @ResponseBody Collection<User> showUserList() {
    return chirperService.getUsers(MAX_USER_COUNT);
  }
 
  @RequestMapping(value = "/message/{id}", method = RequestMethod.GET, headers = {"Accept=text/xml, application/json"})
  public @ResponseBody Message showMessage(@PathVariable Long id) {
    return chirperService.getMessage(id);
  }
  
  @RequestMapping(value = "/user/{userId}/messages", method = RequestMethod.GET, headers = {"Accept=text/xml, application/json"})
  public @ResponseBody Collection<Message> showMessageList(@PathVariable Long userId) {
    return chirperService.getMessagesByUserId(userId);
  }
  
  @RequestMapping(value = "/user", method = RequestMethod.POST, headers = {"Accept=text/xml, application/json"})
  public @ResponseBody Boolean createUser(@RequestParam String username, 
                                          @RequestParam String password, 
                                          @RequestParam(required = false) Boolean receiveEmail) {    
    if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
      return Boolean.FALSE;
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
    
    return result;
  }
  
  @RequestMapping(value = "/message", method = RequestMethod.POST, headers = {"Accept=text/xml, application/json"})
  public @ResponseBody Boolean createMessage(@RequestParam String content, @RequestParam Long userId) {
    if (StringUtils.isBlank(content) || userId == null) {
      return Boolean.FALSE;
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
    
    return result;
  }
  
  @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT, headers = {"Accept=text/xml, application/json"})
  public @ResponseBody Boolean updateUser(@PathVariable Long id, 
                                          @RequestParam String username,
                                          @RequestParam String password,
                                          @RequestParam String joinDate,
                                          @RequestParam(required = false) Boolean receiveEmail) { 
    DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    Date parsedDate = null;
    
    try {
      parsedDate = dateFormat.parse(joinDate);
    } catch (ParseException ex) {
      logger.error(ex);
    }
    
    if (receiveEmail == null) {
      receiveEmail = Boolean.FALSE;
    }
    
    User user = new User();
    user.setId(id);
    user.setUsername(username);
    user.setPassword(password);
    user.setJoinDate(parsedDate);
    user.setReceiveEmail(receiveEmail);
    
    return chirperService.updateUser(user);
  }
  
  @RequestMapping(value = "/message/{id}", method = RequestMethod.PUT, headers = {"Accept=text/xml, application/json"})
  public @ResponseBody Boolean updateMessage(@PathVariable Long id, 
                                             @RequestParam String content, 
                                             @RequestParam String creationDate,
                                             @RequestParam Long userId) {
    DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    Date parsedDate = null;
    
    try {
      parsedDate = dateFormat.parse(creationDate);
    } catch (ParseException ex) {
      logger.error(ex);
    }
    
    Message message = new Message();
    message.setId(id);
    message.setContent(content);
    message.setCreationDate(parsedDate);
    message.setUserId(userId);
    
    return chirperService.updateMessage(message);
  }
  
  @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE, headers = {"Accept=text/xml, application/json"})
  public @ResponseBody Boolean deleteUser(@PathVariable Long id) {
    return chirperService.deleteUser(id);
  }
  
  @RequestMapping(value = "/message/{id}", method = RequestMethod.DELETE, headers = {"Accept=text/xml, application/json"})
  public @ResponseBody Boolean deleteMessage(@PathVariable Long id) {
    return chirperService.deleteMessage(id);
  }
}
