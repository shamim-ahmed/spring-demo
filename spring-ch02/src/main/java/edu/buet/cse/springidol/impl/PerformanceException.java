package edu.buet.cse.springidol.impl;

public class PerformanceException extends Exception {
  private static final long serialVersionUID = 1L;
  
  public PerformanceException() {
	this("Exception during performance");
  }
  
  public PerformanceException(String message) {
	super(message);
  }
}
