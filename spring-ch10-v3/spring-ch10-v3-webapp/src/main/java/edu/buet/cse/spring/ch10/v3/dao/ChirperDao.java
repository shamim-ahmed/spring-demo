package edu.buet.cse.spring.ch10.v3.dao;

import java.util.Collection;

import edu.buet.cse.spring.ch10.v3.model.Message;
import edu.buet.cse.spring.ch10.v3.model.User;

public interface ChirperDao {
  User getUser(Long id);

  Message getMessage(Long id);

  Collection<User> getUsers(int count);

  Collection<Message> getMessagesByUserId(Long userId);

  boolean addUser(User user);

  boolean addMessage(Message message);
}
