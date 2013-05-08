package edu.buet.cse.spring.ch12.v5.actor;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch12.v5.model.Tweet;
import edu.buet.cse.spring.ch12.v5.service.LoggingService;

public class Producer {
  public static void main(String[] args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch12/v5/spring-beans.xml");
    LoggingService loggingService = appContext.getBean("loggingService", LoggingService.class);
    
    Tweet tweet = new Tweet("This is a test", new Date());
    loggingService.log(tweet);
  }
}
