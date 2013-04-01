package edu.buet.cse.spring.ch03.v4.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.buet.cse.spring.ch03.v4.model.Instrument;
import edu.buet.cse.spring.ch03.v4.model.Performer;

@Component("yanni")
public class Musician implements Performer {
  private final Instrument musicalInstrument;

  @Autowired
  public Musician(@Qualifier("piano") Instrument musiInstrument) {
    this.musicalInstrument = Objects.requireNonNull(musiInstrument);
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