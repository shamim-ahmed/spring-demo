package edu.buet.cse.spring.ch07.v1.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.buet.cse.spring.ch07.v1.dao.ChirperDao;
import edu.buet.cse.spring.ch07.v1.model.Message;
import edu.buet.cse.spring.ch07.v1.model.User;

@Component("chirperService")
public class ChirperServiceImpl implements ChirperService {
  public static final int MAX_MESSAGE_COUNT = 10;
  private final ChirperDao chirperDao;
  
  @Autowired
  public ChirperServiceImpl(ChirperDao chirperDao) {
    this.chirperDao = chirperDao;
  }
  
  @Override
  public User getUser(Long id) {
    if (id == null) {
      return null;
    }
    
    return chirperDao.getUser(id);
  }

  @Override
  public Message getMessage(Long id) {
    if (id == null) {
      return null;
    }
    
    return chirperDao.getMessage(id);
  }

  @Override
  public List<Message> getMessages(int count) {
    if (count <= 0) {
      return Collections.emptyList();
    }
    
    if (count > MAX_MESSAGE_COUNT) {
      count = MAX_MESSAGE_COUNT;
    }
    
    return chirperDao.getLatestMessages(count);
  }

  @Override
  public boolean addUser(User user) {
    return chirperDao.createUser(user);
  }

  @Override
  public boolean addMessage(Message message) {
    return chirperDao.createMessage(message);
  }
}
