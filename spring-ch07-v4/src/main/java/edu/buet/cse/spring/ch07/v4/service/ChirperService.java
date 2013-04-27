package edu.buet.cse.spring.ch07.v4.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import edu.buet.cse.spring.ch07.v4.model.Message;
import edu.buet.cse.spring.ch07.v4.model.User;

/**
 * A dummy implementation of a service class
 * 
 * @author shamim
 * 
 */
public class ChirperService {
  private final Map<Long, User> users;
  private final Map<Long, Message> messages;

  public ChirperService() {
    users = new LinkedHashMap<>();
    messages = new LinkedHashMap<>();
  }

  public void init() {
    initUsers();
    initMessages();
  }
  
  private void initUsers() {
    Long[] ids = { 1L, 2L, 3L };
    String[] usernames = { "johnson", "gavin", "joshua" };
    String[] passwords = { "spring", "hibernate", "effectiveJava" };
    Date[] joinDates = { new Date(), new Date(), new Date() };
    boolean[] receiveEmails = { false, true, false };

    for (int i = 0, n = ids.length; i < n; i++) {
      User user = new User();
      user.setId(ids[i]);
      user.setUsername(usernames[i]);
      user.setPassword(passwords[i]);
      user.setJoinDate(joinDates[i]);
      user.setReceiveEmail(receiveEmails[i]);
      users.put(user.getId(), user);
    }
  }
  
  private void initMessages() {
    Long[] ids = {1L, 2L, 3L};
    String[] contents = {"Spring rocks !", "Hibernate rocks !", "Effective Java rocks !"};
    Date[] creationDates = {new Date(), new Date(), new Date()};
    Long[] userIds = {1L, 2L, 3L};
    
    for (int i = 0, n = ids.length; i < n; i++) {
      Message message = new Message();
      message.setId(ids[i]);
      message.setContent(contents[i]);
      message.setCreationDate(creationDates[i]);
      message.setUserId(userIds[i]);
      messages.put(message.getId(), message);
    }
  }

  public List<User> getUsers() {
    return new ArrayList<>(users.values());
  }
  
  public List<Message> getMessages() {
    return new ArrayList<>(messages.values());
  }
  
  public User getUser(Long id) {
    return users.get(id);
  }
  
  public Message getMessage(Long id) {
    return messages.get(id);
  }
}
