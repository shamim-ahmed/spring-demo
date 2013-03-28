package edu.buet.cse.spring.ch02.spel;

import java.util.Collections;
import java.util.List;

public class SelectedCityContainer {
  private List<City> selectedCities;
  private City firstCity;
  private City lastCity;

  public List<City> getSelectedCities() {
    return Collections.unmodifiableList(selectedCities);
  }

  public void setSelectedCities(List<City> selectedCities) {
    this.selectedCities = selectedCities;
  }

  public City getFirstCity() {
    return firstCity;
  }

  public void setFirstCity(City firstCity) {
    this.firstCity = firstCity;
  }

  public City getLastCity() {
    return lastCity;
  }

  public void setLastCity(City lastCity) {
    this.lastCity = lastCity;
  }
}