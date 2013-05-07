package edu.buet.cse.spring.ch11.v2.service;

import java.util.Collection;
import java.util.Collections;

import org.apache.commons.lang3.StringUtils;

import edu.buet.cse.spring.ch11.v2.dao.ChirperDao;
import edu.buet.cse.spring.ch11.v2.model.Message;
import edu.buet.cse.spring.ch11.v2.model.User;
import edu.buet.cse.spring.ch11.v2.service.ChirperService;

public class ChirperServiceImpl implements ChirperService {
  public static final int MAX_USER_COUNT = 10;
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
  public Collection<User> getUsers(int count) {
    if (count <= 0) {
      return Collections.emptyList();
    }

    if (count > MAX_USER_COUNT) {
      count = MAX_USER_COUNT;
    }

    return chirperDao.getUsers(count);
  }

  @Override
  public Collection<Message> getMessagesByUserId(Long userId) {
    if (userId == null) {
      return Collections.emptyList();
    }

    return chirperDao.getMessagesByUserId(userId);
  }

  @Override
  public boolean addUser(User user) {
    if (user == null) {
      return false;
    }

    return chirperDao.addUser(user);
  }

  @Override
  public boolean addMessage(Message message) {
    if (message == null) {
      return false;
    }

    return chirperDao.addMessage(message);
  }

  @Override
  public boolean updateUser(User user) {
    if (user == null || user.getId() == null || StringUtils.isBlank(user.getPassword())) {
      return false;
    }

    return chirperDao.updateUser(user);
  }

  @Override
  public boolean updateMessage(Message message) {
    if (message == null || message.getId() == null || StringUtils.isBlank(message.getContent())) {
      return false;
    }

    return chirperDao.updateMessage(message);
  }

  @Override
  public boolean deleteUser(Long id) {
    if (id == null) {
      return false;
    }

    return chirperDao.deleteUser(id);
  }

  @Override
  public boolean deleteMessage(Long id) {
    if (id == null) {
      return false;
    }
    
    return chirperDao.deleteMessage(id);
  }
}
