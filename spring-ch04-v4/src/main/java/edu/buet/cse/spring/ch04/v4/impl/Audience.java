package edu.buet.cse.spring.ch04.v4.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
  @Pointcut("execution(* edu.buet.cse.spring.ch04.v4.model.Performer.perform(..))")
  public void performance() {
    // this method exists only for the purpose of PointCut declaration.
  }

  @Around("performance()")
  public void watchPerformance(ProceedingJoinPoint joinPoint) {
    System.out.println("The audience are taking their seats");
    System.out.println("The audience are turning off their cell phones");

    try {
      long start = System.currentTimeMillis();
      joinPoint.proceed();
      long end = System.currentTimeMillis();
      
      System.out.println("Audience : CLAP CLAP CLAP");
      System.out.printf("The performance took %d ms", end - start);
    } catch (Throwable t) {
      System.out.println("Audience : BOO ! We want our money back !");
      t.printStackTrace(System.err);
    }
  }
}
