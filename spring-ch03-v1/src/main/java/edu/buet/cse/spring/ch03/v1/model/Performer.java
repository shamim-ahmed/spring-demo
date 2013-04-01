package edu.buet.cse.spring.ch03.v1.model;

import edu.buet.cse.spring.ch03.v1.ex.PerformanceException;

public interface Performer {
  void perform() throws PerformanceException;
}