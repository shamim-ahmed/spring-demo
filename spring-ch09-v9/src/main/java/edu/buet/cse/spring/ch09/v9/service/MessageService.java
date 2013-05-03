package edu.buet.cse.spring.ch09.v9.service;

import java.util.Collection;
import java.util.Date;
import java.util.TreeMap;

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
  
  public synchronized Message getMessageById(Long id) {
    return messageMap.get(id);
  }
  
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public synchronized Collection<Message> getMessages() {
    return messageMap.values();
  }
  
  public synchronized void addMessage(Message message) {
    Long max = messageMap.lastKey();
    
    if (max == null) {
      max = 0L;
    }
    
    message.setId(max + 1);
    messageMap.put(message.getId(), message);
  }
}
