package edu.buet.cse.spring.ch03.v3.impl;

import edu.buet.cse.spring.ch03.v3.model.Knife;
import edu.buet.cse.spring.ch03.v3.model.Provider;

public class KnifeProvider implements Provider<Knife> {
  
  @Override
  public Knife get() {
    return new Kukri();
  }
}
