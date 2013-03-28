package edu.buet.cse.spring.ch02.impl;

import edu.buet.cse.spring.ch02.model.Performer;

public class BeanJuggler implements Performer {
  private int beanCount;

  public void setBeanCount(int beanCount) {
    this.beanCount = beanCount;
  }
  
  public int getBeanCount() {
    return beanCount;
  }
    
  @Override
  public void perform() {
	System.out.printf("I'm juggling %d beans%n", beanCount);
  }
}
