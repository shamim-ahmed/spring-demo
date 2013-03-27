package edu.buet.cse.springidol.spel;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class City {
  private String name;
  private String state;
  private int population;

  public String getName() {
	return name;
  }

  public void setName(String name) {
	this.name = name;
  }

  public String getState() {
	return state;
  }

  public void setState(String state) {
	this.state = state;
  }

  public int getPopulation() {
	return population;
  }

  public void setPopulation(int population) {
	this.population = population;
  }
  
  @Override
  public String toString() {
	ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
	builder.append("name", name)
	       .append("state", state)
	       .append("population", population);
	
	return builder.toString();
  }
}