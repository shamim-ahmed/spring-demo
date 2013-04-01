package edu.buet.cse.spring.ch03.v2.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import edu.buet.cse.spring.ch03.v2.model.Instrument;
import edu.buet.cse.spring.ch03.v2.model.Performer;

public class Musician implements Performer {
  // example of qualification with bean name
  @Autowired
  @Qualifier("guiter")
  private Instrument musicalInstrument;

  public void setMusicalInstrument(Instrument musicalInstrument) {
    this.musicalInstrument = musicalInstrument;
  }

  public Instrument getMusicalInstrument() {
    return musicalInstrument;
  }

  @Override
  public void perform() {
    System.out.printf("Playing the instrument %s%n", musicalInstrument.getName());
    musicalInstrument.play();
  }
}