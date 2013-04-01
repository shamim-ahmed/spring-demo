package edu.buet.cse.spring.ch03.impl;

import edu.buet.cse.spring.ch03.model.Instrument;

public class Saxophone implements Instrument {
  private static final String SAXOPHONE_NAME = "Saxophone";

  @Override
  public String getName() {
    return SAXOPHONE_NAME;
  }

  @Override
  public void play() {
    System.out.println("TOOT TOOT TOOOOOOOOT");
  }
}