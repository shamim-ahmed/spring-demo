package edu.buet.cse.spring.ch03.model;

import edu.buet.cse.spring.ch03.ex.PerformanceException;

public interface Performer {
  void perform() throws PerformanceException;
}