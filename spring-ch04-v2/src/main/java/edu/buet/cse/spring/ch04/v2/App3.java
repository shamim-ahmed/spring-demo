package edu.buet.cse.spring.ch04.v2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App3 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch04/v2/spring-beans.xml");
    Object yanni = appContext.getBean("yanni");
    
    try {
      yanni.getClass().getMethod("receiveAward").invoke(yanni);
    } catch (Exception ex) {
      ex.printStackTrace(System.err);
    }
  }
}
