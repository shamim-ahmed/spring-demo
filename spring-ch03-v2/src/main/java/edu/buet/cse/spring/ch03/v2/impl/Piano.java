package edu.buet.cse.spring.ch03.v2.impl;

import edu.buet.cse.spring.ch03.v2.model.Instrument;

public class Piano implements Instrument {
  private static final String PIANO_NAME = "Piano";

  @Override
  public String getName() {
    return PIANO_NAME;
  }

  @Override
  public void play() {
    System.out.println("TING TING TINNNNNG");
  }
}