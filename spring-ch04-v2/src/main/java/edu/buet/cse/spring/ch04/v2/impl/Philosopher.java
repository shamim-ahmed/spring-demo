package edu.buet.cse.spring.ch04.v2.impl;

import edu.buet.cse.spring.ch04.v2.model.Thinker;

public class Philosopher implements Thinker {

  @Override
  public void thinkOfSomething(String thought) {
    System.out.printf("I'm thinking of %s%n", thought);
  }
}
