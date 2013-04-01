package edu.buet.cse.spring.ch03.v4.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.buet.cse.spring.ch03.v4.model.Performer;
import edu.buet.cse.spring.ch03.v4.model.Poem;

@Component("herrick")
public class PoemReciter implements Performer {
  @Autowired
  @Qualifier("toDaffodils")
  private Poem poem;

  public Poem getPoem() {
    return poem;
  }

  public void setPoem(Poem poem) {
    this.poem = poem;
  }

  @Override
  public void perform() {
    System.out.println("Reciting the poem:");
    poem.recite();
  }  
}
