package edu.buet.cse.spring.ch08.v4.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class User implements Serializable {
  private static final long serialVersionUID = 1L;
  
  private String mobileNumber;
  private String name;
  private String city;
  private String pizzaName;

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getPizzaName() {
    return pizzaName;
  }

  public void setPizzaName(String pizzaName) {
    this.pizzaName = pizzaName;
  }
  
  @Override
  public String toString() {
    ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
    builder.append("mobileNumber", mobileNumber)
           .append("name", name)
           .append("city", city);
    
    return builder.toString();
  }
}