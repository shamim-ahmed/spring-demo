package edu.buet.cse.spring.ch11.v2.dao;

import java.util.Collection;

import edu.buet.cse.spring.ch11.v2.model.Message;
import edu.buet.cse.spring.ch11.v2.model.User;

public interface ChirperDao {
  User getUser(Long id);

  Message getMessage(Long id);

  Collection<User> getUsers(int count);

  Collection<Message> getMessagesByUserId(Long userId);

  boolean addUser(User user);

  boolean addMessage(Message message);

  boolean updateUser(User user);

  boolean updateMessage(Message message);
  
  boolean deleteUser(Long id);

  boolean deleteMessage(Long id);
}
