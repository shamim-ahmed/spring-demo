package edu.buet.cse.spring.di.impl;

import edu.buet.cse.spring.di.model.Quest;

public class SlayDragonQuest implements Quest {
  
  @Override
  public void embark() {
	System.out.println("The Knight slays the dragon");
  }
}
