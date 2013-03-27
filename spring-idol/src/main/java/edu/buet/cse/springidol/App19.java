package edu.buet.cse.springidol;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.springidol.spel.City;

public class App19 {
  public static void main(String... args) {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/springidol/spring-beans.xml");
	@SuppressWarnings("unchecked")
    List<City> cities = (List<City>) appContext.getBean("cityList");
	
	for (City city : cities) {
	  System.out.println(city);
	}
  }
}
