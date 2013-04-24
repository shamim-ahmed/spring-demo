package edu.buet.cse.spring.ch05.v6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch05.v6.dao.ChirperDao;
import edu.buet.cse.spring.ch05.v6.model.User;

public class App {
  public static void main(String[] args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch05/v6/spring-beans.xml");
    ChirperDao chirperDao = appContext.getBean("chirperDao", ChirperDao.class);
    User user = chirperDao.getUser(1L);
    System.out.println(user);
  }
}
