package edu.buet.cse.spring.ch04.v3.impl;

import java.util.Objects;
import java.util.Random;

import edu.buet.cse.spring.ch04.v3.ex.PerformanceException;
import edu.buet.cse.spring.ch04.v3.model.Instrument;
import edu.buet.cse.spring.ch04.v3.model.Performer;

public class ErraticPerformer implements Performer {
  private static final int MAX = 1000;
  private final Instrument instrument;
  private final Random randomGenerator = new Random(System.currentTimeMillis());

  public ErraticPerformer(Instrument instrument) {
    this.instrument = Objects.requireNonNull(instrument);
  }

  public Instrument getInstrument() {
    return instrument;
  }

  @Override
  public void perform() {
    int n = randomGenerator.nextInt(MAX);

    if (n % 2 == 0) {
      System.out.printf("Playing the instrument %s%n", instrument.getName());
      instrument.play();
    } else {
      throw new PerformanceException("I cannot perform ! My hair is on fire !!");
    }
  }
}
