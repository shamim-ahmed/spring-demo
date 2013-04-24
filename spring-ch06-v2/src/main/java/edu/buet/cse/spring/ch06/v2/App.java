package edu.buet.cse.spring.ch06.v2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch06.v2.dao.ChirperDao;
import edu.buet.cse.spring.ch06.v2.model.User;

public class App {
  public static void main(String[] args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch06/v2/spring-beans.xml");
    ChirperDao chirperDao = appContext.getBean("chirperDao", ChirperDao.class);
    User user = chirperDao.getUser(1L);
    System.out.println(user);
  }
}
