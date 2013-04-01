package edu.buet.cse.spring.ch03.v4.impl;

import org.springframework.stereotype.Component;

import edu.buet.cse.spring.ch03.v4.model.Instrument;

@Component("saxophone")
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