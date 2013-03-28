package edu.buet.cse.spring.ch02.impl;

public class Stage {
  private static class SingletonHolder {
	private static Stage INSTANCE = new Stage();
  }
  
  public static Stage getInstance() {
	return SingletonHolder.INSTANCE;
  }
  
  public void prepare() {
	System.out.println("Opening the curtains...");
	System.out.println("Turning the lights on...");
	System.out.println("The stage is ready to be used now !");
  }
  
  private Stage() {
  }
}
