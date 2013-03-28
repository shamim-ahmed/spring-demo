package edu.buet.cse.spring.basic.impl;

import edu.buet.cse.spring.basic.model.Quest;

public class SlayDragonQuest implements Quest {
  
  @Override
  public void embark() {
	System.out.println("The Knight slays the dragon");
  }
}
