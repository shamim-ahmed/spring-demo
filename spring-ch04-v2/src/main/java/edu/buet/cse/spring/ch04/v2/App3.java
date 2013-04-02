package edu.buet.cse.spring.ch04.v2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch04.v2.model.Contestant;

public class App3 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch04/v2/spring-beans.xml");
    Contestant yanni = appContext.getBean("yanni", Contestant.class);
    yanni.receiveAward();
  }
}
