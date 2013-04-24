package edu.buet.cse.spring.ch05.v6;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch05.v6.dao.ChirperDao;
import edu.buet.cse.spring.ch05.v6.model.User;

public class App5 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch05/v6/spring-beans.xml");
    ChirperDao chirperDao = appContext.getBean("chirperDao", ChirperDao.class);

    User user = new User();
    user.setUsername("joshua");
    user.setPassword("effectiveJava");
    user.setJoinDate(new Date());
    user.setReceiveEmail(false);

    boolean result = chirperDao.createUser(user);

    if (result) {
      System.out.println("User created successfully");
    }
  }
}
