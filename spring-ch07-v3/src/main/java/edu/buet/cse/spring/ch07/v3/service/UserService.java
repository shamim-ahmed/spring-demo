package edu.buet.cse.spring.ch07.v3.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import edu.buet.cse.spring.ch07.v3.model.User;

/**
 * A dummy implementation of a service class
 * 
 * @author shamim
 * 
 */
public class UserService {
  private final List<User> users;
  private final Long[] ids = { 1L, 2L, 3L };
  private final String[] usernames = { "johnson", "gavin", "joshua" };
  private final String[] passwords = { "spring", "hibernate", "effectiveJava" };
  private final Date[] joinDates = { new Date(), new Date(), new Date() };
  private final boolean[] receiveEmails = { false, true, false };

  public UserService() {
    users = new ArrayList<>();
  }

  public void init() {
    for (int i = 0, n = ids.length; i < n; i++) {
      User user = new User();
      user.setId(ids[i]);
      user.setUsername(usernames[i]);
      user.setPassword(passwords[i]);
      user.setJoinDate(joinDates[i]);
      user.setReceiveEmail(receiveEmails[i]);
      users.add(user);
    }
  }

  public List<User> getUsers() {
    return Collections.unmodifiableList(users);
  }
}
