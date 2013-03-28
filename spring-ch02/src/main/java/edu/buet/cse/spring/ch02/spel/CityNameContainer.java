package edu.buet.cse.spring.ch02.spel;

import java.util.Collections;
import java.util.List;

public class CityNameContainer {
  private List<String> cityNames;

  public List<String> getCityNames() {
	return Collections.unmodifiableList(cityNames);
  }

  public void setCityNames(List<String> cityNames) {
	this.cityNames = cityNames;
  }
}