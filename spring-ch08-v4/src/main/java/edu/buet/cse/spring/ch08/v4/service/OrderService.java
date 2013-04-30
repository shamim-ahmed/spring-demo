package edu.buet.cse.spring.ch08.v4.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import edu.buet.cse.spring.ch08.v4.model.Order;

public class OrderService {
  private final Map<String, Order> orderMap = new HashMap<>();
  
  public synchronized Order findOrder(String mobileNumber) {
    return orderMap.get(mobileNumber);
  }
  
  public synchronized void addOrder(Order order) {
    if (order == null || StringUtils.isBlank(order.getMobileNumber())) {
      return;
    }
     
    orderMap.put(order.getMobileNumber(), order);
  }
}
