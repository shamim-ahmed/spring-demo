package edu.buet.cse.springidol.impl;

import edu.buet.cse.springidol.model.Instrument;

public class Piano implements Instrument {
  private static final String PIANO_NAME = "Piano";
  
  @Override
  public String getName() {
	return PIANO_NAME;
  }

  @Override
  public void play() {
	System.out.println("PLINK PLINK PLINK");
  }
}
