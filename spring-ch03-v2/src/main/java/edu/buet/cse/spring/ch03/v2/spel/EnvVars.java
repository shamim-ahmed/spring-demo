package edu.buet.cse.spring.ch03.v2.spel;

import org.springframework.beans.factory.annotation.Value;

// this class contains examples of property injection using the @Value annotation
public class EnvVars {
  @Value("#{systemEnvironment['HOME']}")
  private String home;

  @Value("#{systemEnvironment['PATH']}")
  private String path;

  @Value("#{systemEnvironment['USER']}")
  private String user;

  public String getHome() {
    return home;
  }

  public void setHome(String home) {
    this.home = home;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }
}
