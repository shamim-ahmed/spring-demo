package edu.buet.cse.spring.ch10.v4.service;

import java.util.Collection;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import edu.buet.cse.spring.ch10.v4.model.Message;
import edu.buet.cse.spring.ch10.v4.model.User;

@Component
@WebService(serviceName = "ChirperService")
public class ChirperServiceEndPoint extends SpringBeanAutowiringSupport implements ChirperService {
  @Autowired
  private ChirperService chirperService;

  @Override
  public User getUser(Long id) {
    return chirperService.getUser(id);
  }

  @Override
  public Message getMessage(Long id) {
    return chirperService.getMessage(id);
  }

  @Override
  public Collection<User> getUsers(int count) {
    return chirperService.getUsers(count);
  }

  @Override
  public Collection<Message> getMessagesByUserId(Long userId) {
    return chirperService.getMessagesByUserId(userId);
  }

  @Override
  public boolean addUser(User user) {
    return chirperService.addUser(user);
  }

  @Override
  public boolean addMessage(Message message) {
    return chirperService.addMessage(message);
  }
}
