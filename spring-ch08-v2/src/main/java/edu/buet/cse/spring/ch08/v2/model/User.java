package edu.buet.cse.spring.ch08.v2.model;

import java.io.Serializable;

public class User implements Serializable {
  public static final long serialVersionUID = 1L;

  private String username;
  private String password;
  private String email;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
