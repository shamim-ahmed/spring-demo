package edu.buet.cse.spring.ch12.v3;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import edu.buet.cse.spring.ch12.v3.model.Tweet;

public class Producer {
  public static void main(String[] args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch12/v3/spring-beans.xml");
    JmsTemplate jmsTemplate = appContext.getBean("jmsTemplate", JmsTemplate.class);
    jmsTemplate.send("chirper.queue", new MessageCreator() {      
      @Override
      public Message createMessage(Session session) throws JMSException {
        Tweet tweet = new Tweet("This is a tweet", new Date());
        
        return session.createObjectMessage(tweet);
      }
    });
    
    System.out.println("Tweet produced successfully");
  }
}
