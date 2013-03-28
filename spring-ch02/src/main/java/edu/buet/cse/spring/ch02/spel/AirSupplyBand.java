package edu.buet.cse.spring.ch02.spel;

import edu.buet.cse.spring.ch02.model.Performer;

public class AirSupplyBand implements Performer {
  private String song;

  public String getSong() {
	return song;
  }

  public void setSong(String song) {
	this.song = song;
  }

  @Override
  public void perform() {
	System.out.printf("Performing the song %s%n", song);
  }
}