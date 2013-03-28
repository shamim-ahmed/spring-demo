package edu.buet.cse.spring.ch02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch02.impl.PerformanceException;
import edu.buet.cse.spring.ch02.model.Performer;

public class App7 {
  public static void main(String... args) {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch02/spring-beans.xml");
	Performer yanni = (Performer) appContext.getBean("yanni");

	try {
	  yanni.perform();
	} catch (PerformanceException ex) {
	  ex.printStackTrace(System.err);
	}
  }
}
