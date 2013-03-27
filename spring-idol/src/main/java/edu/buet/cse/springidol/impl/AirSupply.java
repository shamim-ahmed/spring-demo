package edu.buet.cse.springidol.impl;

import edu.buet.cse.springidol.model.Performer;

public class AirSupply implements Performer {
  private String song;

  public String getSong() {
	return song;
  }

  public void setSong(String song) {
	this.song = song;
  }

  @Override
  public void perform() throws PerformanceException {
	System.out.printf("Performing the song %s%n", song);
  }
}