package edu.buet.cse.spring.ch07.v1.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import edu.buet.cse.spring.ch07.v1.dao.ChirperDao;
import edu.buet.cse.spring.ch07.v1.model.Message;
import edu.buet.cse.spring.ch07.v1.model.User;

public class ChirperServiceImpl implements ChirperService {
  public static final int MAX_MESSAGE_COUNT = 10;
  
  private final ChirperDao chirperDao;
  
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
  public boolean addUser(String username, String password, Date joinDate, boolean receiveEmail) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public boolean addMessage(String content, Date creationDate, Long userId) {
    throw new UnsupportedOperationException("Not implemented yet");
  }
}
