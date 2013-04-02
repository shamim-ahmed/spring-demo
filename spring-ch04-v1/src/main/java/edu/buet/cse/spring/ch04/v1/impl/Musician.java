package edu.buet.cse.spring.ch04.v1.impl;

import java.util.Objects;

import edu.buet.cse.spring.ch04.v1.model.Instrument;
import edu.buet.cse.spring.ch04.v1.model.Performer;

public class Musician implements Performer {
  private final Instrument instrument;
  
  public Musician(Instrument instrument) {
    this.instrument = Objects.requireNonNull(instrument);
  }
  
  @Override
  public void perform() {
    System.out.printf("Playing the instrument %s%n", instrument.getName());
    instrument.play();
  }
}
