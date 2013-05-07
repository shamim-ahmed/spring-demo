package edu.buet.cse.spring.ch12.v2;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class Producer {
  public static void main(String[] args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch12/v2/spring-beans.xml");
    JmsTemplate jmsTemplate = appContext.getBean("jmsTemplate", JmsTemplate.class);
    jmsTemplate.send("chirper.queue", new MessageCreator() {      
      @Override
      public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage("Hello World !!");
      }
    });
    
    System.out.println("Message produced successfully");
  }
}
