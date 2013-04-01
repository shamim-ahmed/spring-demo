package edu.buet.cse.spring.ch03.v4.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import edu.buet.cse.spring.ch03.v4.model.Instrument;
import edu.buet.cse.spring.ch03.v4.model.Performer;

@Component("kenny")
public class Instrumentalist implements Performer {
  @Value("Forever in Love")
  private String song;
  
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