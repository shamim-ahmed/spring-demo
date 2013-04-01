package edu.buet.cse.spring.ch03.v3.impl;

import javax.inject.Inject;
import javax.inject.Named;

import edu.buet.cse.spring.ch03.v3.model.Instrument;
import edu.buet.cse.spring.ch03.v3.model.Performer;

public class Instrumentalist implements Performer {
  private String song;
  
  // an example of injection using standard JSR-330 annotation, which is not spring specific
  @Inject
  @Named("saxophone")
  private Instrument instrument;

  public void setSong(String song) {
    this.song = song;
  }

  public String getSong() {
    return song;
  }

  public void setInstrument(Instrument instrument) {
    this.instrument = instrument;
  }

  public Instrument getInstrument() {
    return instrument;
  }

  @Override
  public void perform() {
    System.out.printf("Singing the song %s while playing the instrument %s:%n", song, instrument.getName());
    instrument.play();
  }
}