package edu.buet.cse.spring.ch05.v6;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch05.v6.dao.ChirperDao;
import edu.buet.cse.spring.ch05.v6.model.Message;

public class App2 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch05/v6/spring-beans.xml");
    ChirperDao chirperDao = appContext.getBean("chirperDao", ChirperDao.class);
    List<Message> messages = chirperDao.getLatestMessages(2);
    
    for (Message m : messages) {
      System.out.println(m);
    }
  }
}
