package edu.buet.cse.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.springidol.spel.CircleUtil;

public class App14 {
  public static void main(String... args) {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/springidol/spring-beans.xml");
	CircleUtil circleUtil = (CircleUtil) appContext.getBean("circleUtil");
	System.out.printf("Area = %.2f%n", circleUtil.computeArea(5.0));
	System.out.printf("Circumference = %.2f%n", circleUtil.computeCircumference(5.0));
  }
}