package edu.buet.cse.spring.ch05.v1;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch05.v1.dao.impl.ChirperDaoImpl;
import edu.buet.cse.spring.ch05.v1.model.Message;

public class App2 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch05/v1/spring-beans.xml");
    ChirperDaoImpl chirperDao = appContext.getBean("chirperDao", ChirperDaoImpl.class);
    List<Message> messages = chirperDao.getLatestMessages(5);
    
    for (Message m : messages) {
      System.out.println(m);
    }
  }
}
