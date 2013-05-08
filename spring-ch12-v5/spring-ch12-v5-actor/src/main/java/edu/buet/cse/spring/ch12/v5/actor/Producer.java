package edu.buet.cse.spring.ch12.v5.actor;

import java.util.Date;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch12.v5.model.Tweet;
import edu.buet.cse.spring.ch12.v5.service.LoggingService;

public class Producer {
  private static final String[] MESSAGES = {"In God we trust, others must pay cash",
                                            "There is no place like www.home.com",
                                            "You are unique, just like everyone else",
                                            "Linux forever"};
  
  public static void main(String[] args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch12/v5/spring-beans.xml");
    LoggingService loggingService = appContext.getBean("loggingService", LoggingService.class);
    
    Random randomGenerator = new Random();
    int index = randomGenerator.nextInt(MESSAGES.length);
    
    Tweet tweet = new Tweet(MESSAGES[index], new Date());
    loggingService.log(tweet);
    System.out.println("Tweet logged successfully");
  }
}
