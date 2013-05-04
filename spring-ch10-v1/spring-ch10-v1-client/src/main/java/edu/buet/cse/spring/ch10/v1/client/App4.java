package edu.buet.cse.spring.ch10.v1.client;

import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch10.v1.model.Message;
import edu.buet.cse.spring.ch10.v1.service.ChirperService;

public class App4 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch10/v1/client/spring-beans.xml");
    ChirperService chirperService = appContext.getBean("chirperService", ChirperService.class);
    Collection<Message> messages = chirperService.getMessagesByUserId(1L);
    
    for (Message m : messages) {
      System.out.println(m);
    }
  }
}
