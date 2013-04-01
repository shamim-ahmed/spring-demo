package edu.buet.cse.spring.ch03.v2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch03.v2.spel.EnvVars;

public class App6 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch03/v2/spring-beans.xml");
    EnvVars envVars = appContext.getBean("envVars", EnvVars.class);
    System.out.printf("HOME = %s%n", envVars.getHome());
    System.out.printf("PATH = %s%n", envVars.getPath());
    System.out.printf("USER = %s%n", envVars.getUser());
  }
}
