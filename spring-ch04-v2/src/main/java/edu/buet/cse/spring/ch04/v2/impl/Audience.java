package edu.buet.cse.spring.ch04.v2.impl;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {
  public void watchPerformance(ProceedingJoinPoint joinPoint) {
    System.out.println("The audience is taking their seats");
    System.out.println("The audience is turning their cell phones off");
        
    try {
      long start = System.currentTimeMillis();
      joinPoint.proceed();
      long end = System.currentTimeMillis();
      System.out.println("Audience : CLAP CLAP CLAP");
      System.out.printf("The performance took %d ms%n", end - start);
    } catch (Throwable t) {
      System.out.println("Audience : BOO ! We want our money back !");
      t.printStackTrace(System.err);
    }
  }
}
