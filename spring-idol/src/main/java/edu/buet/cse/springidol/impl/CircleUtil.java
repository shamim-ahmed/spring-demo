package edu.buet.cse.springidol.impl;

public class CircleUtil {
  // this should be equal to Math.PI
  private double multiplier;

  public double getMultiplier() {
	return multiplier;
  }

  public void setMultiplier(double multiplier) {
	this.multiplier = multiplier;
  }
  
  public double computeArea(double radius) {
	return multiplier * Math.pow(radius, 2);
  }
  
  public double computeCircumference(double radius) {
	return 2 * multiplier * radius;
  }
}