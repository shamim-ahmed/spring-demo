package edu.buet.cse.spring.ch06.v5.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.buet.cse.spring.ch06.v5.model.Message;
import edu.buet.cse.spring.ch06.v5.model.User;

@Repository(value = "chirperDao")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ChirperDaoImpl implements ChirperDao {
  public static final int MAX_RESULTS = 10;
  private final HibernateTemplate hibernateTemplate;

  @Autowired
  public ChirperDaoImpl(HibernateTemplate hibernateTemplate) {
    this.hibernateTemplate = hibernateTemplate;
  }

  @Override
  public User getUser(Long id) {
    User user = (User) hibernateTemplate.get(User.class, id);
    return user;
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
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
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public boolean createMessage(Message message) {
    Long id = (Long) hibernateTemplate.save(message);
    return id != null;
  }
}
