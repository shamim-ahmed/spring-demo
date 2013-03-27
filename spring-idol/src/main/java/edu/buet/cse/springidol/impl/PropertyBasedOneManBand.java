package edu.buet.cse.springidol.impl;

import java.util.Properties;

import edu.buet.cse.springidol.model.Performer;

public class PropertyBasedOneManBand implements Performer {
  private final Properties instruments;
  
  public PropertyBasedOneManBand(Properties instruments) {
	this.instruments = instruments;
  }
  
  @Override
  public void perform() {
	for (Object key : instruments.keySet()) {
	  System.out.printf("%s : %s%n", key, instruments.get(key));
	}
  }
}
