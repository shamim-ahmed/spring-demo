package edu.buet.cse.spring.ch05.v1;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch05.v1.dao.ChirperDao;
import edu.buet.cse.spring.ch05.v1.model.Message;
import edu.buet.cse.spring.ch05.v1.model.User;

public class App4 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch05/v1/spring-beans.xml");
    ChirperDao chirperDao = appContext.getBean("chirperDao", ChirperDao.class);

    User user = chirperDao.getUser(1L);

    Message message = new Message();
    message.setContent(String.format("This is the new message from %s", user.getUsername()));
    message.setCreationDate(new Date());
    message.setUserId(user.getId());

    boolean result = chirperDao.createMessage(message);

    if (result) {
      System.out.println("New message created successfully");
    }
  }
}
