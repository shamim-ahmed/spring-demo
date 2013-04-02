package edu.buet.cse.spring.ch04.v2.impl;

import edu.buet.cse.spring.ch04.v2.model.Contestant;

public class GraciousContestant implements Contestant {
  
  @Override
  public void receiveAward() {
    System.out.println("I receive the award graciously, with a smile (and sobs)");
  }
}
