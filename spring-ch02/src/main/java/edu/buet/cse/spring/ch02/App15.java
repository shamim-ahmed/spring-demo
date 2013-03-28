package edu.buet.cse.spring.ch02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch02.spel.Circle;

public class App15 {
  public static void main(String... args) {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch02/spring-beans.xml");
	Circle circle = (Circle) appContext.getBean("circle");
	System.out.printf("Area : %.2f%n", circle.getArea());
	System.out.printf("Circumference : %.2f%n", circle.getCircumference());
  }
}
