package edu.buet.cse.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.springidol.impl.PerformanceException;
import edu.buet.cse.springidol.model.Performer;

public class App2 {
  public static void main(String... args) {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/springidol/spring-beans.xml");
	Performer alanPoe = (Performer) appContext.getBean("alanPoe");

	try {
	  alanPoe.perform();
	} catch (PerformanceException ex) {
	  ex.printStackTrace(System.err);
	}
  }
}
