package edu.buet.cse.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.springidol.impl.PerformanceException;
import edu.buet.cse.springidol.model.Performer;

public class App10 {
  public static void main(String... args) {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/springidol/spring-beans.xml");
	Performer lank = (Performer) appContext.getBean("lank");
	
	try {
	  lank.perform();
	} catch (PerformanceException ex) {
	  ex.printStackTrace(System.err);
	}
  }
}
