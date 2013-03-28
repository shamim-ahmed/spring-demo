package edu.buet.cse.spring.ch02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch02.ex.PerformanceException;
import edu.buet.cse.spring.ch02.model.Performer;

public class App10 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch02/spring-beans.xml");
    Performer lank = (Performer) appContext.getBean("lank");

    try {
      lank.perform();
    } catch (PerformanceException ex) {
      ex.printStackTrace(System.err);
    }
  }
}
