package edu.buet.cse.spring.ch02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch02.impl.Ticket;

public class App4 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch02/spring-beans.xml");
    Ticket ticket1 = (Ticket) appContext.getBean("ticket");
    Ticket ticket2 = (Ticket) appContext.getBean("ticket");

    System.out.println(ticket1 == ticket2);
    System.out.println(ticket1.getId() == ticket2.getId());
  }
}
