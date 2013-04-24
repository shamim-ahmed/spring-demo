package edu.buet.cse.spring.ch05.v6.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "User")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "username", nullable = false, unique = true)
  private String username;
  
  @Column(name = "password", nullable = false)
  private String password;
  
  @Column(name = "join_date", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date joinDate;
  
  @Column(name = "receive_email", nullable = false)
  private boolean receiveEmail;
  
  @OneToMany(mappedBy = "user")
  private Set<Message> messages = new HashSet<>();

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
  
  public Set<Message> getMessages() {
    return messages;
  }

  public void setMessages(Set<Message> messages) {
    this.messages = messages;
  }
  
  @Override
  public String toString() {
    ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
    builder.append("id", id)
           .append("username", username)
           .append("password", password)
           .append("joinDate", joinDate)
           .append("receiveEmail", receiveEmail)
           .append("messageCount", messages.size());
    
    return builder.toString();
  }
}
