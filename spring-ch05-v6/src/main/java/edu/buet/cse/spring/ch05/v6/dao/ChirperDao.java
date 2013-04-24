package edu.buet.cse.spring.ch05.v6.dao;

import java.util.List;

import edu.buet.cse.spring.ch05.v6.model.Message;
import edu.buet.cse.spring.ch05.v6.model.User;

public interface ChirperDao {
  User getUser(Long id);

  boolean createUser(User user);

  Message getMessage(Long id);

  List<Message> getLatestMessages(int count);

  boolean createMessage(Message message);
}
