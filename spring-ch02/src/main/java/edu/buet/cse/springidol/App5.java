package edu.buet.cse.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.springidol.impl.Auditorium;

public class App5 {
  public static void main(String... args) {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/springidol/spring-beans.xml");
	Auditorium auditorium = (Auditorium) appContext.getBean("auditorium");
	auditorium.use();
  }
}
