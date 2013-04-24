package edu.buet.cse.spring.ch05.v6.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.buet.cse.spring.ch05.v6.model.Message;
import edu.buet.cse.spring.ch05.v6.model.User;

@Repository("chirperDao")
@Transactional
public class ChirperDaoImpl implements ChirperDao {
  @PersistenceContext
  private EntityManager entityManager;
  
  @Override
  public User getUser(Long id) {
    User user = entityManager.find(User.class, id);
    return user;
  }

  @Override
  public boolean createUser(User user) {
    entityManager.persist(user);
    entityManager.flush();
    return user.getId() != null;
  }

  @Override
  public Message getMessage(Long id) {
    Message message = entityManager.find(Message.class, id);
    return message;
  }

  @Override
  public List<Message> getLatestMessages(int count) {
    Query query = entityManager.createQuery("SELECT m FROM Message m", Message.class);
    query.setMaxResults(count);
    @SuppressWarnings("unchecked")
    List<Message> messages = query.getResultList();
    
    return messages;
  }

  @Override
  public boolean createMessage(Message message) {
    entityManager.persist(message);
    entityManager.flush();
    
    return message.getId() != null;
  } 
}
