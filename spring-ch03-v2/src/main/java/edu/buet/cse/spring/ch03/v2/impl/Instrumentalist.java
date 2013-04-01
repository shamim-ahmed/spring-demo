package edu.buet.cse.spring.ch03.v2.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import edu.buet.cse.spring.ch03.v2.model.Instrument;
import edu.buet.cse.spring.ch03.v2.model.Performer;

public class Instrumentalist implements Performer {
  private String song;
  
  // example of qualification with bean name
  @Autowired
  @Qualifier("saxophone")
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