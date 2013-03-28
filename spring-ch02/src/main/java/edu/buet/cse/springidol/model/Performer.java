package edu.buet.cse.springidol.model;

import edu.buet.cse.springidol.impl.PerformanceException;

public interface Performer {
  void perform() throws PerformanceException;
}
