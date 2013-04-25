package edu.buet.cse.spring.ch07.v1.service;

import java.util.Date;
import java.util.List;

import edu.buet.cse.spring.ch07.v1.model.Message;
import edu.buet.cse.spring.ch07.v1.model.User;

public interface ChirperService {
  User getUser(Long id);
  Message getMessage(Long id);
  List<Message> getMessages(int count);
  boolean addUser(String username, String password, Date joinDate, boolean receiveEmail);
  boolean addMessage(String content, Date creationDate, Long userId);
}
