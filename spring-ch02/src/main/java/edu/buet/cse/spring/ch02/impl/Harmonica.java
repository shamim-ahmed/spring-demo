package edu.buet.cse.spring.ch02.impl;

import edu.buet.cse.spring.ch02.model.Instrument;

public class Harmonica implements Instrument {
  private static final String HARMONICA_NAME = "Harmonica";

  @Override
  public String getName() {
    return HARMONICA_NAME;
  }

  @Override
  public void play() {
    System.out.println("POM POM POM");
  }
}
