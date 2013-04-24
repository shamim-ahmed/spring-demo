package edu.buet.cse.spring.ch06.v3;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import edu.buet.cse.spring.ch06.v3.dao.ChirperDao;
import edu.buet.cse.spring.ch06.v3.model.Message;
import edu.buet.cse.spring.ch06.v3.model.User;

public class App4 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch06/v3/spring-beans.xml");
    final ChirperDao chirperDao = appContext.getBean("chirperDao", ChirperDao.class);
    TransactionTemplate txTemplate = appContext.getBean("txTemplate", TransactionTemplate.class);
    
    txTemplate.execute(new TransactionCallback() {
      @Override
      public Object doInTransaction(TransactionStatus txStatus) {
        try {
          User user = chirperDao.getUser(1L);

          Message message = new Message();
          message.setContent(String.format("This is the new message from %s", user.getUsername()));
          message.setCreationDate(new Date());
          message.setUser(user);

          boolean result = chirperDao.createMessage(message);

          if (result) {
            System.out.println("New message created successfully");
          }
        } catch (Exception ex) {
          txStatus.isRollbackOnly();
          throw ex;
        }

        return null;
      }
    });
  }
}
