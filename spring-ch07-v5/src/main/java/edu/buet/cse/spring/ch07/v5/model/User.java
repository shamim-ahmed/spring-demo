package edu.buet.cse.spring.ch07.v5.model;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class User {
  private Long id;
  private String username;
  private String password;
  private Date joinDate;
  private boolean receiveEmail;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public Date getJoinDate() {
    return joinDate;
  }

  public void setJoinDate(Date joinDate) {
    this.joinDate = joinDate;
  }

  public boolean isReceiveEmail() {
    return receiveEmail;
  }

  public void setReceiveEmail(boolean receiveEmail) {
    this.receiveEmail = receiveEmail;
  }
  
  @Override
  public String toString() {
    ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
    builder.append("id", id)
           .append("username", username)
           .append("password", password)
           .append("joinDate", joinDate)
           .append("receiveEmail", receiveEmail);
    
    return builder.toString();
  }
}
