package edu.buet.cse.spring.ch05.v3.dao;

import java.util.List;

import edu.buet.cse.spring.ch05.v3.model.Message;
import edu.buet.cse.spring.ch05.v3.model.User;

public interface ChirperDao {
  User getUser(Long id);

  boolean createUser(User user);

  Message getMessage(Long id);

  List<Message> getLatestMessages(int count);

  boolean createMessage(Message message);
}
