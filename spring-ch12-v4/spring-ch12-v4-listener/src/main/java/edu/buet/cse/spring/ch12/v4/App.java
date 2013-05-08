package edu.buet.cse.spring.ch12.v4;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch12/v4/spring-beans.xml");
    System.out.printf("The context was loaded at %s%n", new Date(appContext.getStartupDate()));
  }
}
