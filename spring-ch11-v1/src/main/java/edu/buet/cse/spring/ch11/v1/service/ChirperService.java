package edu.buet.cse.spring.ch11.v1.service;

import java.util.Collection;

import javax.jws.WebService;

import edu.buet.cse.spring.ch11.v1.model.Message;
import edu.buet.cse.spring.ch11.v1.model.User;

@WebService
public interface ChirperService {
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
