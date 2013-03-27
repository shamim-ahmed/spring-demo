package edu.buet.cse.springidol.spel;

import java.util.Collections;
import java.util.List;

public class SelectedCityContainer {
  private List<City> selectedCities;

  public List<City> getSelectedCities() {
    return Collections.unmodifiableList(selectedCities);
  }

  public void setSelectedCities(List<City> selectedCities) {
    this.selectedCities = selectedCities;
  }  
}