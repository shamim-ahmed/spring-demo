package edu.buet.cse.spring.ch03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch03.ex.PerformanceException;
import edu.buet.cse.spring.ch03.model.Performer;

public class App2 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch03/spring-beans.xml");
    Performer poe = (Performer) appContext.getBean("poe");
    
    try {
      poe.perform();
    } catch (PerformanceException ex) {
      ex.printStackTrace(System.err);
    }
  }
}
