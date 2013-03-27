package edu.buet.cse.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.springidol.spel.CityNameContainer;

public class App23 {
  public static void main(String... args) {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/springidol/spring-beans.xml");
	CityNameContainer container = (CityNameContainer) appContext.getBean("cityNameContainer3");
	
	for (String name : container.getCityNames()) {
	  System.out.println(name);
	}
  }
}
