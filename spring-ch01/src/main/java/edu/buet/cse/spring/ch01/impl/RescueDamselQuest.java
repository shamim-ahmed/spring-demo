package edu.buet.cse.spring.ch01.impl;

import edu.buet.cse.spring.ch01.model.Quest;

public class RescueDamselQuest implements Quest {
  @Override
  public void embark() {
    System.out.println("The Knight rescues the damsel");
  }
}
