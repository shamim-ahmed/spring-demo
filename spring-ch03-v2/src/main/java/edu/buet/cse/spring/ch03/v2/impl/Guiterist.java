package edu.buet.cse.spring.ch03.v2.impl;

import org.springframework.beans.factory.annotation.Autowired;

import edu.buet.cse.spring.ch03.v2.model.Instrument;
import edu.buet.cse.spring.ch03.v2.model.Performer;
import edu.buet.cse.spring.ch03.v2.qualifier.StringedInstrument;

public class Guiterist implements Performer {
  // an example of qualification using a custom annotation
  @Autowired
  @StringedInstrument
  private Instrument instrument;
  
  public Instrument getInstrument() {
    return instrument;
  }

  public void setInstrument(Instrument instrument) {
    this.instrument = instrument;
  }

  @Override
  public void perform() {
    System.out.printf("Playing the instrument %s%n", instrument.getName());
    instrument.play();
  }
}