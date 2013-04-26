package edu.buet.cse.spring.ch07.v1.service;

import java.util.List;

import edu.buet.cse.spring.ch07.v1.model.Message;
import edu.buet.cse.spring.ch07.v1.model.User;

public interface ChirperService {
  User getUser(Long id);
  Message getMessage(Long id);
  List<Message> getMessages(int count);
  boolean addUser(User user);
  boolean addMessage(Message message);
}
