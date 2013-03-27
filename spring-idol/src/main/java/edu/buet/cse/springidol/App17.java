package edu.buet.cse.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.springidol.spel.SystemProperties;

public class App17 {
  public static void main(String... args) {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/springidol/spring-beans.xml");
	SystemProperties sysProps = (SystemProperties) appContext.getBean("sysProps");
	System.out.printf("java.home = %s%n", sysProps.getJavaHome());
	System.out.printf("line.separator = %s%n", sysProps.getLineSeparator());
	System.out.printf("java.vendor = %s%n", sysProps.getJavaVendor());
  }
}
