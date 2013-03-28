package edu.buet.cse.spring.ch02.model;

import edu.buet.cse.spring.ch02.ex.PerformanceException;

public interface Performer {
  void perform() throws PerformanceException;
}
