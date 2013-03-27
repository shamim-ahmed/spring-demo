package edu.buet.cse.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.springidol.spel.City;
import edu.buet.cse.springidol.spel.SelectedCityContainer;

public class App20 {
  public static void main(String... args) {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/springidol/spring-beans.xml");
    SelectedCityContainer container = (SelectedCityContainer) appContext.getBean("selectedCityContainer");
	
	for (City city : container.getSelectedCities()) {
	  System.out.println(city);
	}
  }
}