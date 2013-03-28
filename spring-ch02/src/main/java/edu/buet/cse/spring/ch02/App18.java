package edu.buet.cse.spring.ch02;

import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App18 {
  public static void main(String... args) {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch02/spring-beans.xml");
	Properties props = (Properties) appContext.getBean("settings");
	props.list(System.out);
  }
}
