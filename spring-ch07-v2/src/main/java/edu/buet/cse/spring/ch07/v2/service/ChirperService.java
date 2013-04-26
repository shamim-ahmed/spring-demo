package edu.buet.cse.spring.ch07.v2.service;

import java.util.List;

import edu.buet.cse.spring.ch07.v2.model.Message;
import edu.buet.cse.spring.ch07.v2.model.User;

public interface ChirperService {
  User getUser(Long id);

  User getUser(String username);

  Message getMessage(Long id);

  List<Message> getMessages(int count);
  
  List<Message> getMessagesFromUser(Long userId, int count);

  boolean addUser(User user);

  boolean addMessage(Message message);
}
