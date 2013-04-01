package edu.buet.cse.spring.ch03.v3.impl;

import javax.inject.Inject;

import edu.buet.cse.spring.ch03.v3.model.Instrument;
import edu.buet.cse.spring.ch03.v3.model.Performer;
import edu.buet.cse.spring.ch03.v3.qualifier.StringedInstrument;

public class Guiterist implements Performer {
  private final Instrument instrument;
  
  @Inject
  public Guiterist(@StringedInstrument Instrument instrument) {
    this.instrument = instrument;
  }
  
  public Instrument getInstrument() {
    return instrument;
  }
  
  @Override
  public void perform() {
    System.out.printf("Playing the instrument %s: %n", instrument.getName());
    instrument.play();
  }
}
