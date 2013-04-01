package edu.buet.cse.spring.ch03.impl;

import edu.buet.cse.spring.ch03.model.Performer;
import edu.buet.cse.spring.ch03.model.Poem;

public class PoeticJuggler implements Performer {
  private Poem poem;
  private int beanCount;

  public void setPoem(Poem poem) {
    this.poem = poem;
  }

  public void setBeanCount(int beanCount) {
    this.beanCount = beanCount;
  }

  public Poem getPoem() {
    return poem;
  }

  public int getBeanCount() {
    return beanCount;
  }

  @Override
  public void perform() {
    System.out.printf("Juggling %d beans while reciting the poem:%n", beanCount);
    poem.recite();
  }
}