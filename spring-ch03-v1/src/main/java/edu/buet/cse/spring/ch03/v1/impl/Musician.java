package edu.buet.cse.spring.ch03.v1.impl;

import java.util.Objects;

import edu.buet.cse.spring.ch03.v1.model.Instrument;
import edu.buet.cse.spring.ch03.v1.model.Performer;

public class Musician implements Performer {
  private final Instrument musicalInstrument;

  public Instrument getMusicalInstrument() {
    return musicalInstrument;
  }
  
  public Musician(Instrument musiInstrument) {
    this.musicalInstrument = Objects.requireNonNull(musiInstrument);
  }

  @Override
  public void perform() {
    System.out.printf("Playing the instrument %s%n", musicalInstrument.getName());
    musicalInstrument.play();
  }
}