package edu.buet.cse.springidol.impl;

import java.util.Objects;

import edu.buet.cse.springidol.model.Performer;
import edu.buet.cse.springidol.model.Poem;

public class PoeticJuggler implements Performer {
  private final Poem poem;
  private final int beanCount;
  
  public PoeticJuggler(Poem poem, int beanCount) {
	this.poem = Objects.requireNonNull(poem);
	this.beanCount = beanCount;
  }

  @Override
  public void perform() {
	System.out.printf("Juggling %d beans while reciting the poem:%n", beanCount);
	poem.recite();
  }
}
