package edu.buet.cse.spring.ch12.v5.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Tweet implements Serializable {
  private static final long serialVersionUID = 1L;
  private final String content;
  private final Date creationDate;
  
  public Tweet(String content, Date creationDate) {
    this.content = content;
    this.creationDate = creationDate;
  }

  public String getContent() {
    return content;
  }

  public Date getCreationDate() {
    return creationDate;
  }
  
  @Override
  public String toString() {
    ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
    builder.append("content", content)
           .append("creationDate", creationDate);
    
    return builder.toString();
  }
}
 