package edu.buet.cse.spring.di.impl;

import java.util.Objects;

import edu.buet.cse.spring.di.model.Knight;
import edu.buet.cse.spring.di.model.Quest;

public class BraveKnight implements Knight {
  private Quest quest;

  public BraveKnight(Quest quest) {
	this.quest = Objects.requireNonNull(quest);
  }

  @Override
  public void embarkOnQuest() {
	quest.embark();
  }
}