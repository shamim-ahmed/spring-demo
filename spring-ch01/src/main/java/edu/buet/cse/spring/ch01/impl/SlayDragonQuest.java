package edu.buet.cse.spring.ch01.impl;

import edu.buet.cse.spring.ch01.model.Quest;

public class SlayDragonQuest implements Quest {

  @Override
  public void embark() {
    System.out.println("The Knight slays the dragon");
  }
}