package edu.buet.cse.spring.ch10.v4.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch10.v4.model.Message;
import edu.buet.cse.spring.ch10.v4.service.ChirperService;

public class App2 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch10/v4/client/spring-beans.xml");
    ChirperService chirperService = appContext.getBean("chirperService", ChirperService.class);
    Message message = chirperService.getMessage(1L);
    System.out.println(message);
  }
}
