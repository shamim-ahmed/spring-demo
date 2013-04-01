package edu.buet.cse.spring.ch03.v3.impl;

import edu.buet.cse.spring.ch03.v3.model.Knife;

public class Kukri implements Knife {
  private static final String KNIFE_NAME = "Kukri";
  
  @Override
  public String getName() {
    return KNIFE_NAME;
  }

  @Override
  public void use() {
    System.out.printf("Using knife %s%n", KNIFE_NAME);
  }
}