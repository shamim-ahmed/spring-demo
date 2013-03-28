package edu.buet.cse.spring.ch02.model;

import edu.buet.cse.spring.ch02.impl.PerformanceException;

public interface Performer {
  void perform() throws PerformanceException;
}
