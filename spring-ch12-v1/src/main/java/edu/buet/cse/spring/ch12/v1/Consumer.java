package edu.buet.cse.spring.ch12.v1;

import javax.jms.JMSException;
import javax.jms.Message;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class Consumer {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch12/v1/spring-beans.xml");
    JmsTemplate jmsTemplate = appContext.getBean("jmsTemplate", JmsTemplate.class);
    Message message = jmsTemplate.receive("chirper.queue");
    
    if (message instanceof ActiveMQTextMessage) {
      ActiveMQTextMessage textMessage = (ActiveMQTextMessage) message;
      
      try {
        System.out.printf("The retrieved message is : %s%n", textMessage.getText());
      } catch (JMSException ex) {
        ex.printStackTrace(System.err);
      }
    }
  }
}
