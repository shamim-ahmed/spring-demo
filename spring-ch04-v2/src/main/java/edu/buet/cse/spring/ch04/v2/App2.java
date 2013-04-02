package edu.buet.cse.spring.ch04.v2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.ch04.v2.model.MindReader;
import edu.buet.cse.spring.ch04.v2.model.Thinker;

public class App2 {
  public static void main(String... args) {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("/edu/buet/cse/spring/ch04/v2/spring-beans.xml");
    Thinker plato = appContext.getBean("plato", Thinker.class);
    plato.thinkOfSomething("The Origin of Epistemology");
    
    MindReader houdini = appContext.getBean("houdini", MindReader.class);
    System.out.printf("What the mind reader intercepted : %s%n", houdini.getThought());
  }
}
