package edu.buet.cse.spring.ch10.v3.client;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch10.v3.model.Message;
import edu.buet.cse.spring.ch10.v3.service.ChirperService;

public class App6 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch10/v3/client/spring-beans.xml");
    ChirperService chirperService = appContext.getBean("chirperService", ChirperService.class);
    Message message = new Message();
    message.setContent("This is a test");
    message.setCreationDate(new Date());
    message.setUserId(1L);
    
    boolean result = false;
    
    try {
      result = chirperService.addMessage(message);
    } catch (Exception ex) {
      ex.printStackTrace(System.err);
    }
    
    System.out.printf("The message %s created successfully%n", result ? "was" : "was not");
  }
}
