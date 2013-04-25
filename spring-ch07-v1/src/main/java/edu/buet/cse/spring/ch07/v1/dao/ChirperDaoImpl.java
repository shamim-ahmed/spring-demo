package edu.buet.cse.spring.ch07.v1.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.buet.cse.spring.ch07.v1.model.Message;
import edu.buet.cse.spring.ch07.v1.model.User;

@Component("chirperDao")
public class ChirperDaoImpl implements ChirperDao {

  @Override
  public User getUser(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean createUser(User user) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Message getMessage(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Message> getLatestMessages(int count) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean createMessage(Message message) {
    // TODO Auto-generated method stub
    return false;
  }
  
}
