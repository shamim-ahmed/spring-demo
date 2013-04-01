package edu.buet.cse.spring.ch03.v2.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import edu.buet.cse.spring.ch03.v2.ex.PerformanceException;
import edu.buet.cse.spring.ch03.v2.model.Performer;
import edu.buet.cse.spring.ch03.v2.model.Poem;

public class PoemReciter implements Performer {
  //example of qualification with attribute (added in the bean source code)
  @Autowired
  @Qualifier("philosophical")
  private Poem poem;

  public Poem getPoem() {
    return poem;
  }

  public void setPoem(Poem poem) {
    this.poem = poem;
  }

  @Override
  public void perform() throws PerformanceException {
    System.out.println("Reciting the poem:");
    poem.recite();
  }  
}