package edu.buet.cse.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.springidol.impl.PerformanceException;
import edu.buet.cse.springidol.model.Performer;

public class App8 {
  public static void main(String... args) {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/springidol/spring-beans.xml");
	Performer hank = (Performer) appContext.getBean("hank");
	
	try {
	  hank.perform();
	} catch (PerformanceException ex) {
	  ex.printStackTrace(System.err);
	}
  }
}
