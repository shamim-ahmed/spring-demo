package edu.buet.cse.spring.ch03.v2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch03.v2.model.Performer;

public class App3 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch03/v2/spring-beans.xml");
    Performer yanni = (Performer) appContext.getBean("yanni");
    yanni.perform();
  }
}
