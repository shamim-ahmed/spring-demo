package edu.buet.cse.spring.ch01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch01.jdbc.User;
import edu.buet.cse.spring.ch01.jdbc.UserDao;

public class App3 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch01/spring-beans.xml");
    UserDao userDao = (UserDao) appContext.getBean("userDao");
    User user = userDao.getUser(1L);
    System.out.println(user);
  }
}
