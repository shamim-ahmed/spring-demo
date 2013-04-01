package edu.buet.cse.spring.ch03.v4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch03.v4.model.Performer;

public class App2 {
  public static void main(String[] args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch03/v4/spring-beans.xml");
    Performer yanni = appContext.getBean("yanni", Performer.class);
    yanni.perform();
  }
}
