package edu.buet.cse.spring.ch03.v3.impl;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import edu.buet.cse.spring.ch03.v3.model.Instrument;
import edu.buet.cse.spring.ch03.v3.model.Performer;

public class Musician implements Performer {
  private final Instrument musicalInstrument;

  public Instrument getMusicalInstrument() {
    return musicalInstrument;
  }

  // injection using standard JSR-330 annotation with qualification
  @Inject
  @Named("piano")
  public Musician(Instrument musiInstrument) {
    this.musicalInstrument = Objects.requireNonNull(musiInstrument);
  }

  @Override
  public void perform() {
    System.out.printf("Playing the instrument %s%n", musicalInstrument.getName());
    musicalInstrument.play();
  }
}
