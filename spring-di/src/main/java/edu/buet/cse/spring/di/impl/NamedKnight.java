package edu.buet.cse.spring.di.impl;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import edu.buet.cse.spring.di.model.Knight;

public class NamedKnight implements Knight, BeanNameAware, ApplicationContextAware {
  private String beanName;
  private ApplicationContext applicationContext;
  
  @Override
  public void setBeanName(String beanName) {
	this.beanName = beanName;
  }

  @Override
  public void embarkOnQuest() {
	System.out.printf("The knight with name %s and context %s embarks on a quest%n", beanName, applicationContext.getDisplayName());
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) {
	this.applicationContext = applicationContext;
  }
}