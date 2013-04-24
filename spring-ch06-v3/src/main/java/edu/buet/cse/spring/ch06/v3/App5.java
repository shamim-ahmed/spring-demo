package edu.buet.cse.spring.ch06.v3;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import edu.buet.cse.spring.ch06.v3.dao.ChirperDao;
import edu.buet.cse.spring.ch06.v3.model.User;

public class App5 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch06/v3/spring-beans.xml");
    final ChirperDao chirperDao = appContext.getBean("chirperDao", ChirperDao.class);
    TransactionTemplate txTemplate = appContext.getBean("txTemplate", TransactionTemplate.class);

    txTemplate.execute(new TransactionCallback() {
      @Override
      public Object doInTransaction(TransactionStatus txStatus) {
        try {
          User user = new User();
          user.setUsername("joshua");
          user.setPassword("effectiveJava");
          user.setJoinDate(new Date());
          user.setReceiveEmail(false);

          boolean result = chirperDao.createUser(user);

          if (result) {
            System.out.println("User created successfully");
          }
        } catch (Exception ex) {
          txStatus.setRollbackOnly();
          throw ex;
        }

        return null;
      }
    });
  }
}
