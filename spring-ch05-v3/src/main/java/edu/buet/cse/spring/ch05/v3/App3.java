package edu.buet.cse.spring.ch05.v3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch05.v3.dao.ChirperDao;
import edu.buet.cse.spring.ch05.v3.model.Message;

public class App3 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch05/v3/spring-beans.xml");
    ChirperDao chirperDao = appContext.getBean("chirperDao", ChirperDao.class);
    Message message = chirperDao.getMessage(1L);
    System.out.println(message);
  }
}
