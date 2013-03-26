package edu.buet.cse.springidol.impl;

import java.util.Collection;

import edu.buet.cse.springidol.model.Instrument;
import edu.buet.cse.springidol.model.Performer;

public class OneManBand implements Performer {
  private Collection<Instrument> instruments;

  public void setInstruments(Collection<Instrument> instruments) {
	this.instruments = instruments;
  }

  @Override
  public void perform() throws PerformanceException {
	System.out.printf("Playing several instruments all alone:%n");

	for (Instrument instr : instruments) {
	  instr.play();
	}
  }
}
