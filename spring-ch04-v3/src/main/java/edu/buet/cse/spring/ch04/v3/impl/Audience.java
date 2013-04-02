package edu.buet.cse.spring.ch04.v3.impl;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
  @Pointcut("execution(* edu.buet.cse.spring.ch04.v3.model.Performer.perform(..))")
  public void performance() {
    // this method exists only for the purpose of PointCut declaration. 
  }
  
  @Before("performance()")
  public void takeSeats() {    
    System.out.println("The audience are taking their seats");
  }
  
  @Before("performance()")
  public void turnOffCellPhones() {
    System.out.println("The audience are turning off their cell phones");
  }
  
  @AfterReturning("performance()")
  public void applaud() {
    System.out.println("Audience : CLAP CLAP CLAP");
  }
  
  @AfterThrowing("performance()")
  public void demandRefund() {
    System.out.println("BOO ! We want our money back !");
  }
}
