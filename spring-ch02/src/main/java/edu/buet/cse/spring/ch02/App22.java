package edu.buet.cse.spring.ch02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch02.spel.CityNameContainer;

public class App22 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch02/spring-beans.xml");
    CityNameContainer container = (CityNameContainer) appContext.getBean("cityNameContainer2");

    for (String name : container.getCityNames()) {
      System.out.println(name);
    }
  }
}
