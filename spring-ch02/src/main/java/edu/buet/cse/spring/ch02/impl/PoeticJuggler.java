package edu.buet.cse.spring.ch02.impl;

import java.util.Objects;

import edu.buet.cse.spring.ch02.model.Performer;
import edu.buet.cse.spring.ch02.model.Poem;

public class PoeticJuggler implements Performer {
  private final Poem poem;
  private final int beanCount;

  public PoeticJuggler(Poem poem, int beanCount) {
    this.poem = Objects.requireNonNull(poem);
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
