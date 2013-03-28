package edu.buet.cse.spring.ch02.impl;

import edu.buet.cse.spring.ch02.model.Instrument;

public class Flute implements Instrument {
  private static final String FLUTE_LABEL = "Flute";
  
  @Override
  public String getName() {
	return FLUTE_LABEL;
  }

  @Override
  public void play() {
	System.out.println("PAW PAW PAAAAW");
  }
}
