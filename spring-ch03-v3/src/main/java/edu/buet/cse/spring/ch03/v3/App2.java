package edu.buet.cse.spring.ch03.v3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch03.v3.model.Performer;

public class App2 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch03/v3/spring-beans.xml");
    Performer duke = appContext.getBean("duke", Performer.class);
    duke.perform();
  }
}