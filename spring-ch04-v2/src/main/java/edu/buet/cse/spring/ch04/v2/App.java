package edu.buet.cse.spring.ch04.v2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch04.v2.model.Performer;

public class App {
  public static void main(String[] args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch04/v2/spring-beans.xml");
    Performer bieber = appContext.getBean("bieber", Performer.class);
    bieber.perform();
  }
}
