package edu.buet.cse.spring.ch04.v3.ex;

public class PerformanceException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  
  public PerformanceException() {
    this("Exception during performance");
  }
  
  public PerformanceException(String message) {
    super(message);
  }
}
