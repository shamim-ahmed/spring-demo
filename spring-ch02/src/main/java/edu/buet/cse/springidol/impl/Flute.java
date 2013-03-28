package edu.buet.cse.springidol.impl;

import edu.buet.cse.springidol.model.Instrument;

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
