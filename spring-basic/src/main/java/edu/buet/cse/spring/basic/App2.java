package edu.buet.cse.spring.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.basic.model.Knight;

public class App2 {
  public static void main(String... args) {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/spring-beans.xml");
	Knight knight = (Knight) appContext.getBean("clarkKent");
	knight.embarkOnQuest();
  }
}