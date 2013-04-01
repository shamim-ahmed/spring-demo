package edu.buet.cse.spring.ch03.v4;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch03.v4.model.Performer;

public class App4 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch03/v4/spring-beans.xml");
    listBeansOfType(appContext, Performer.class);
  }
  
  private static <T> void listBeansOfType(ApplicationContext appContext, Class<T> classObj) {
    Map<String, T> map = appContext.getBeansOfType(classObj);
    
    for (Map.Entry<String, T> entry : map.entrySet()) {
      System.out.printf("key = %s, value = %s%n",  entry.getKey(), entry.getValue());
    }
  }
}
