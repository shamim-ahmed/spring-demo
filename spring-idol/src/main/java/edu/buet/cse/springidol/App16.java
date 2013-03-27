package edu.buet.cse.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.springidol.spel.EnvVars;

public class App16 {
  public static void main(String... args) {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/springidol/spring-beans.xml");
	EnvVars envvars = (EnvVars) appContext.getBean("envvars");
	System.out.printf("HOME = %s%n", envvars.getHome());
	System.out.printf("PATH = %s%n", envvars.getPath());
	System.out.printf("USER = %s%n", envvars.getUser());
  }
}
