package edu.buet.cse.spring.ch03.v2.model;

import edu.buet.cse.spring.ch03.v2.ex.PerformanceException;

public interface Performer {
  void perform() throws PerformanceException;
}