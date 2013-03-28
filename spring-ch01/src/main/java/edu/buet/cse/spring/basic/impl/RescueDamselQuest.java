package edu.buet.cse.spring.basic.impl;

import edu.buet.cse.spring.basic.model.Quest;

public class RescueDamselQuest implements Quest {
  @Override
  public void embark() {
	System.out.println("The Knight rescues the damsel");
  }
}
