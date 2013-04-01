package edu.buet.cse.spring.ch03.v4.impl;

import org.springframework.stereotype.Component;

import edu.buet.cse.spring.ch03.v4.model.Instrument;

@Component("piano")
public class Piano implements Instrument {
  private static final String PIANO_NAME = "Piano";
  
  @Override
  public String getName() {
    return PIANO_NAME;
  }

  @Override
  public void play() {
    System.out.println("PING PING PINNNNNG");
  }
}
