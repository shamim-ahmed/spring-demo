package edu.buet.cse.spring.ch07.v2.dao;

import java.util.List;

import edu.buet.cse.spring.ch07.v2.model.Message;
import edu.buet.cse.spring.ch07.v2.model.User;

public interface ChirperDao {
  User getUser(Long id);

  User getUser(String username);

  boolean createUser(User user);

  Message getMessage(Long id);

  List<Message> getLatestMessages(int count);
  
  List<Message> getLatestMessagesFromUser(Long userId, int count);

  boolean createMessage(Message message);
}
