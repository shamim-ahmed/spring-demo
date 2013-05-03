package edu.buet.cse.spring.ch09.v9.controller;

import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.buet.cse.spring.ch09.v9.model.Message;
import edu.buet.cse.spring.ch09.v9.service.MessageService;

@Controller
public class ChirperController {
  private MessageService messageService;

  @Autowired
  public ChirperController(MessageService messageService) {
    this.messageService = messageService;
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String showHome() {
    return "home";
  }

  @RequestMapping(value = "/login-form", method = RequestMethod.GET)
  public String showLoginForm() {
    return "loginForm";
  }

  @RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
  public String getMessageById(@PathVariable Long id, ModelMap modelMap) {
    Message message = messageService.getMessageById(id);
    modelMap.put("message", message);

    return "message";
  }

  @RequestMapping(value = "/message-list", method = RequestMethod.GET)
  public String getMessages(ModelMap modelMap) {
    Collection<Message> messages = messageService.getMessages();
    modelMap.put("messages", messages);

    return "messageList";
  }

  @RequestMapping(value = "/message", method = RequestMethod.POST)
  public String createMessage(@RequestParam String content, @RequestParam String username) {
    if (StringUtils.isBlank(content) || StringUtils.isBlank(username)) {
      return "failure";
    }

    Message message = new Message();
    message.setContent(content);
    message.setCreationDate(new Date());
    message.setUsername(username);

    messageService.addMessage(message);
    return "success";
  }

  @RequestMapping(value = "/message-form", method = RequestMethod.GET)
  public String showMessageForm() {
    return "messageForm";
  }

  @RequestMapping(value = "/message-search-form", method = RequestMethod.GET)
  public String showMessageSearchForm() {
    return "messageSearchForm";
  }
}
