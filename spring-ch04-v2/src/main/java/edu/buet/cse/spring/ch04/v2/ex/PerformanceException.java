package edu.buet.cse.spring.ch04.v2.ex;

public class PerformanceException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  
  public PerformanceException() {
    this("Exception during performance");
  }
  
  public PerformanceException(String message) {
    super(message);
  }
}
