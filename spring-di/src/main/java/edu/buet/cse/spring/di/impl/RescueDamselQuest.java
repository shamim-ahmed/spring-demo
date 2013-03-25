package edu.buet.cse.spring.di.impl;

import edu.buet.cse.spring.di.model.Quest;

public class RescueDamselQuest implements Quest {
  @Override
  public void embark() {
	System.out.println("The Knight rescues the damsel");
  }
}
