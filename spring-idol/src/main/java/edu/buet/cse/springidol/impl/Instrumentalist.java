package edu.buet.cse.springidol.impl;

import edu.buet.cse.springidol.model.Instrument;
import edu.buet.cse.springidol.model.Performer;

public class Instrumentalist implements Performer {
  private String song;
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
