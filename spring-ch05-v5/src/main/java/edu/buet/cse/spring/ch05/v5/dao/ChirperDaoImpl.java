package edu.buet.cse.spring.ch05.v5.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import edu.buet.cse.spring.ch05.v5.model.Message;
import edu.buet.cse.spring.ch05.v5.model.User;

@Repository
public class ChirperDaoImpl extends HibernateDaoSupport implements ChirperDao {
  public static final int MAX_RESULTS = 10;
  
  @Override
  public User getUser(Long id) {
    User user = (User) getHibernateTemplate().get(User.class, id);
    return user;
  }

  @Override
  public boolean createUser(User user) {
    Long id = (Long) getHibernateTemplate().save(user);
    return id != null;
  }

  @Override
  public Message getMessage(Long id) {
    Message message = (Message) getHibernateTemplate().get(Message.class, id);
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
    
    HibernateTemplate template = getHibernateTemplate();
    template.setMaxResults(count);
    
    @SuppressWarnings("unchecked")
    List<Message> messages = template.find("from Message m order by m.id desc");
    return messages;
  }

  @Override
  public boolean createMessage(Message message) {
    Long id = (Long) getHibernateTemplate().save(message);
    return id != null;
  }
}
