package edu.buet.cse.spring.ch08.v4.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import edu.buet.cse.spring.ch08.v4.model.User;

public class UserService {
  private static final Map<String, User> userMap = new HashMap<>();
  
  public synchronized static User getUser(String mobileNumber) {
    if (mobileNumber.equals("123456")) {
      return new User();
    }
    
    return userMap.get(mobileNumber);
  }
  
  public synchronized static void addUser(User user) {
    if (user == null || StringUtils.isBlank(user.getMobileNumber())) {
      return;
    }
        
    userMap.put(user.getMobileNumber(), user);
  }
  
  private UserService() {
  }
}
