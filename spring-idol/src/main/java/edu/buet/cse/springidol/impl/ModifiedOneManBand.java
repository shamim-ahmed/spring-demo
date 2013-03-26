package edu.buet.cse.springidol.impl;

import java.util.Map;

import edu.buet.cse.springidol.model.Instrument;
import edu.buet.cse.springidol.model.Performer;

public class ModifiedOneManBand implements Performer {
  private final Map<String, Instrument> instrumentMap;
  
  public ModifiedOneManBand(Map<String, Instrument> instrumentMap) {
	this.instrumentMap = instrumentMap;
  }
  
  @Override
  public void perform() {
	for (String key : instrumentMap.keySet()) {
	  Instrument instr = instrumentMap.get(key);
	  System.out.printf("%s: ", key);
	  instr.play();
	}
  }
}
