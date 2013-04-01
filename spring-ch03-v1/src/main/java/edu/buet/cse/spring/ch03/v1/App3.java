package edu.buet.cse.spring.ch03.v1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch03.v1.ex.PerformanceException;
import edu.buet.cse.spring.ch03.v1.model.Performer;

public class App3 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch03/v1/spring-beans.xml");
    Performer benny = (Performer) appContext.getBean("benny");

    try {
      benny.perform();
    } catch (PerformanceException ex) {
      ex.printStackTrace(System.err);
    }
  }
}