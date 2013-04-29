package edu.buet.cse.spring.ch08.v4.service;

import org.apache.commons.lang3.StringUtils;

public class CityService {
  private static final String[] cityNames = {"Sydney", "Canberra", "Melbourne"};
  
  public static boolean isDeliveryAvailable(String city) {
    if (StringUtils.isBlank(city)) {
      return false;
    }
    
    boolean result = false;
    
    for (String s : cityNames) {
      if (s.equalsIgnoreCase(city)) {
        result = true;
        break;
      }
    }
    
    return result;
  }
  
  private CityService() {
  }
}
