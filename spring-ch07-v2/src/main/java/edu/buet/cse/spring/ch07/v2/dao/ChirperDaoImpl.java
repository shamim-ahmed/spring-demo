package edu.buet.cse.spring.ch07.v2.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.buet.cse.spring.ch07.v2.model.Message;
import edu.buet.cse.spring.ch07.v2.model.User;

@Repository("chirperDao")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ChirperDaoImpl implements ChirperDao {
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
  public User getUser(String username) {
    @SuppressWarnings("unchecked")
    List<User>  users = hibernateTemplate.findByNamedParam("from User u where u.username = :name", "name", username);
    
    if (users != null && users.size() == 1) {
      return users.get(0);
    }
    
    return null;
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
    hibernateTemplate.setMaxResults(count);
    @SuppressWarnings("unchecked")
    List<Message> messages = hibernateTemplate.find("from Message m order by m.id desc");
    
    return messages;
  }
  
  @Override
  public List<Message> getLatestMessagesFromUser(Long userId, int count) {
    hibernateTemplate.setMaxResults(count);
    @SuppressWarnings("unchecked")
    List<Message> messages = hibernateTemplate.findByNamedParam("from Message m where m.user.id = :id order by m.id desc", "id", userId);
    
    return messages;
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public boolean createMessage(Message message) {
    Long id = (Long) hibernateTemplate.save(message);
    return id != null;
  }
}
