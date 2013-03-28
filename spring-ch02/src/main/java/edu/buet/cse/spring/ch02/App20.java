package edu.buet.cse.spring.ch02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch02.spel.City;
import edu.buet.cse.spring.ch02.spel.SelectedCityContainer;

public class App20 {
  public static void main(String... args) {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch02/spring-beans.xml");
    SelectedCityContainer container = (SelectedCityContainer) appContext.getBean("selectedCityContainer");
	
    System.out.println("Selected cities: ");
    
	for (City city : container.getSelectedCities()) {
	  System.out.println(city);
	}
	
	System.out.printf("%n%nFirst city: %s%n", container.getFirstCity());
	System.out.printf("%n%nLast city: %s%n", container.getLastCity());
  }
}