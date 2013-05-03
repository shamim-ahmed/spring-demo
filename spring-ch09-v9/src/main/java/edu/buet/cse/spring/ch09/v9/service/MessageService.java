package edu.buet.cse.spring.ch09.v9.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import edu.buet.cse.spring.ch09.v9.model.Message;

/**
 * A dummy service class
 * @author shamim
 *
 */
@Component
public class MessageService {
  private final TreeMap<Long, Message> messageMap = new TreeMap<>();
  private final String[] contents = {"Spring rocks", "Hibernate rocks", "Yiruma is brilliant", "Gradle rocks", "Seam framework rocks"};
  private final String[] usernames = {"johnson", "gavin", "shamim", "johnson", "gavin"};
  
  public MessageService() {
    // initialize with dummy data
    for (int i = 0, n = contents.length; i < n; i++) {
      Message message = new Message();
      message.setId(Long.valueOf(i + 1));
      message.setContent(contents[i]);
      message.setCreationDate(new Date());
      message.setUsername(usernames[i]);
      messageMap.put(message.getId(), message);
    }
  }
  
  @PostAuthorize("returnObject.username == principal.username")
  public synchronized Message getMessageById(Long id) {
    return messageMap.get(id);
  }
  
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PostFilter("filterObject.username == principal.username")
  public synchronized List<Message> getMessages() {
    return new ArrayList<>(messageMap.values());
  }
  
  @PreAuthorize("(hasRole('ROLE_USER') and #message.content.length() <= 50) or hasRole('ROLE_ADMIN')")
  public synchronized void addMessage(Message message) {
    Long max = messageMap.lastKey();
    
    if (max == null) {
      max = 0L;
    }
    
    message.setId(max + 1);
    messageMap.put(message.getId(), message);
  }
}
