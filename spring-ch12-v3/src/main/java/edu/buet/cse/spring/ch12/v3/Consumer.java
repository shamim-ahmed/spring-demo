package edu.buet.cse.spring.ch12.v3;

import javax.jms.JMSException;
import javax.jms.Message;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class Consumer {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch12/v3/spring-beans.xml");
    JmsTemplate jmsTemplate = appContext.getBean("jmsTemplate", JmsTemplate.class);
    Message message = jmsTemplate.receive("chirper.queue");
    
    if (message instanceof ActiveMQObjectMessage) {
      ActiveMQObjectMessage objectMessage = (ActiveMQObjectMessage) message;
      
      try {
        System.out.printf("The retrieved tweet is : %s%n", objectMessage.getObject());
      } catch (JMSException ex) {
        ex.printStackTrace(System.err);
      }
    }
  }
}
