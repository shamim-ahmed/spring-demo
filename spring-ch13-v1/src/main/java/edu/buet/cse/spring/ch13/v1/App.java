package edu.buet.cse.spring.ch13.v1;

import java.io.IOException;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
  public static void main(String[] args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch13/v1/spring-beans.xml");
    System.out.printf("Application context loaded at %s%n", new Date(appContext.getStartupDate()));
    System.out.println("Press any key to continue.....");
    
    try {
      System.in.read();
    } catch (IOException ex) {
      ex.printStackTrace(System.err);
    }
  }
}
