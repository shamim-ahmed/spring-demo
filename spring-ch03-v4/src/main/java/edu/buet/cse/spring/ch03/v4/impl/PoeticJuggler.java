package edu.buet.cse.spring.ch03.v4.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import edu.buet.cse.spring.ch03.v4.model.Performer;
import edu.buet.cse.spring.ch03.v4.model.Poem;

@Component("duke")
public class PoeticJuggler implements Performer {
  @Autowired
  @Qualifier("toHelen")
  private Poem poem;
  
  @Value("8")
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