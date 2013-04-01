package edu.buet.cse.spring.ch03.v3.impl;

import edu.buet.cse.spring.ch03.v3.model.Instrument;
import edu.buet.cse.spring.ch03.v3.qualifier.StringedInstrument;

@StringedInstrument
public class Guiter implements Instrument {
  private static final String GUITER_NAME = "Guiter";

  @Override
  public String getName() {
    return GUITER_NAME;
  }

  @Override
  public void play() {
    System.out.println("DING DING DINNNNNG");
  }
}
