package edu.buet.cse.spring.ch02;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch02.spel.City;

public class App19 {
  public static void main(String... args) {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch02/spring-beans.xml");
	@SuppressWarnings("unchecked")
    List<City> cities = (List<City>) appContext.getBean("cities");
	
	for (City city : cities) {
	  System.out.println(city);
	}
  }
}
