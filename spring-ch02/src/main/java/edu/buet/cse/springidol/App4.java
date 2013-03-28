package edu.buet.cse.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.springidol.impl.Ticket;

public class App4 {
  public static void main(String... args) {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/springidol/spring-beans.xml");
	Ticket ticket1 = (Ticket) appContext.getBean("ticket");
	Ticket ticket2 = (Ticket) appContext.getBean("ticket");
	
	System.out.println(ticket1 == ticket2);
	System.out.println(ticket1.getId() == ticket2.getId());
  }
}
