package edu.buet.cse.spring.ch04.v2.impl;

import edu.buet.cse.spring.ch04.v2.model.MindReader;

public class Magician implements MindReader {
  private String thought;
  
  @Override
  public void interceptThought(String thought) {
    System.out.println("Intercepting thought...");
    this.thought = thought;
  }

  @Override
  public String getThought() {
    return thought;
  }
}
