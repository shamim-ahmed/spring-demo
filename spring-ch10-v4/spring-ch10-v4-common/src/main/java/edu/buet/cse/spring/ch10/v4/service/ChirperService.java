package edu.buet.cse.spring.ch10.v4.service;

import java.util.Collection;

import javax.jws.WebService;

import edu.buet.cse.spring.ch10.v4.model.Message;
import edu.buet.cse.spring.ch10.v4.model.User;

@WebService
public interface ChirperService {
  User getUser(Long id);

  Message getMessage(Long id);

  Collection<User> getUsers(int count);

  Collection<Message> getMessagesByUserId(Long userId);

  boolean addUser(User user);

  boolean addMessage(Message message);
}
