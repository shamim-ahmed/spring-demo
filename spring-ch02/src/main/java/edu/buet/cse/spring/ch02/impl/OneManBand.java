package edu.buet.cse.spring.ch02.impl;

import java.util.Collection;
import java.util.Collections;

import edu.buet.cse.spring.ch02.model.Instrument;
import edu.buet.cse.spring.ch02.model.Performer;

public class OneManBand implements Performer {
  private Collection<Instrument> instruments;

  public void setInstruments(Collection<Instrument> instruments) {
	this.instruments = instruments;
  }
  
  public Collection<Instrument> getInstruments() {
    return Collections.unmodifiableCollection(instruments);
  }

  @Override
  public void perform() throws PerformanceException {
	System.out.printf("Playing several instruments all alone:%n");

	for (Instrument instr : instruments) {
	  instr.play();
	}
  }
}
