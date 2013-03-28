package edu.buet.cse.spring.ch01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch01.model.Knight;

public class App {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch01/spring-beans.xml");
    Knight knight = (Knight) appContext.getBean("knight");
    knight.embarkOnQuest();
  }
}
