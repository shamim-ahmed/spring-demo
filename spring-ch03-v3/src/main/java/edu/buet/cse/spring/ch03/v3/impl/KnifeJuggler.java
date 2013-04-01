package edu.buet.cse.spring.ch03.v3.impl;

import java.util.HashSet;

import javax.inject.Inject;

import edu.buet.cse.spring.ch03.v3.model.Knife;
import edu.buet.cse.spring.ch03.v3.model.Performer;
import edu.buet.cse.spring.ch03.v3.model.Provider;

public class KnifeJuggler implements Performer {
  private static final int MAX = 5;
  private final HashSet<Knife> knives;
  
  // example of injecting a provider
  @Inject
  public KnifeJuggler(Provider<Knife> provider) {
    knives = new HashSet<>();
    
    for (int i = 0; i < MAX; i++) {
      knives.add(provider.get());
    }
  }

  @Override
  public void perform() {
    System.out.printf("About to show tricks with %d knives %n", knives.size());
    
    for (Knife k : knives) {
      k.use();
    }
  }
}