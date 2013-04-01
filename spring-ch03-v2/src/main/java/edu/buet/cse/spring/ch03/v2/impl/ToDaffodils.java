package edu.buet.cse.spring.ch03.v2.impl;

import org.springframework.beans.factory.annotation.Qualifier;

import edu.buet.cse.spring.ch03.v2.model.Poem;

@Qualifier("philosophical")
public class ToDaffodils implements Poem {
  private static final String[] LINES = {
    "Fair Daffodils, we weep to see", 
    "You haste away so soon;",
    "As yet the early-rising sun", 
    "Has not attain'd his noon.", 
    "Stay, stay,", 
    "Until the hasting day", 
    "Has run",
    "But to the even-song;", 
    "And, having pray'd together, we", 
    "Will go with you along.",
    "We have short time to stay, as you", 
    "We have as short a spring;", 
    "As quick a growth to meet decay,",
    "As you, or anything.", 
    "We die", 
    "As your hours do, and dry", 
    "Away,", 
    "Like to the summer's rain;",
    "Or as the pearls of morning's dew,", 
    "Ne'er to be found again. "
  };
  
  @Override
  public void recite() {
    for (String line : LINES) {
      System.out.println(line);
    }
  }
}