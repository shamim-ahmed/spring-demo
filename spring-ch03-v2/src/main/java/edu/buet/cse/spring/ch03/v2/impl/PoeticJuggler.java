package edu.buet.cse.spring.ch03.v2.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import edu.buet.cse.spring.ch03.v2.model.Performer;
import edu.buet.cse.spring.ch03.v2.model.Poem;

public class PoeticJuggler implements Performer {
  // example of qualification with attribute (added in the bean source code)
  @Autowired
  @Qualifier("romantic")
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