package edu.buet.cse.spring.ch05.v3.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import edu.buet.cse.spring.ch05.v3.model.Message;
import edu.buet.cse.spring.ch05.v3.model.User;

public class ChirperDaoImpl implements ChirperDao {
  public static final int MAX_RESULTS = 10;
  private final HibernateTemplate hibernateTemplate;

  public ChirperDaoImpl(HibernateTemplate hibernateTemplate) {
    this.hibernateTemplate = hibernateTemplate;
  }

  @Override
  public User getUser(Long id) {
    User user = (User) hibernateTemplate.get(User.class, id);
    return user;
  }

  @Override
  public boolean createUser(User user) {
    Long id = (Long) hibernateTemplate.save(user);
    return id != null;
  }

  @Override
  public Message getMessage(Long id) {
    Message message = (Message) hibernateTemplate.get(Message.class, id);
    return message;
  }

  @Override
  public List<Message> getLatestMessages(int count) {
    if (count <= 0) {
      return Collections.emptyList();
    }
    
    if (count > MAX_RESULTS) {
      count = MAX_RESULTS;
    }
    
    hibernateTemplate.setMaxResults(count);
    
    @SuppressWarnings("unchecked")
    List<Message> messages = hibernateTemplate.find("from Message");
    return messages;
  }

  @Override
  public boolean createMessage(Message message) {
    Long id = (Long) hibernateTemplate.save(message);
    return id != null;
  }
}
