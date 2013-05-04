package edu.buet.cse.spring.ch10.v2.client;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch10.v2.model.User;
import edu.buet.cse.spring.ch10.v2.service.ChirperService;

public class App5 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch10/v2/client/spring-beans.xml");
    ChirperService chirperService = appContext.getBean("chirperService", ChirperService.class);
    
    User user = new User();
    user.setUsername("shamim");
    user.setPassword("secret");
    user.setJoinDate(new Date());
    user.setReceiveEmail(true);
    
    boolean result = false;
    
    try {
      result = chirperService.addUser(user);
    } catch (Exception ex) {
      ex.printStackTrace(System.err);
    }
    
    System.out.printf("The user %s created successfully%n", result ? "is" : "is not");
  }
}
