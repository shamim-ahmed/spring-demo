package edu.buet.cse.spring.ch01.impl;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import edu.buet.cse.spring.ch01.model.Knight;

public class NamedKnight implements Knight, BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {
  private String beanName;
  private ApplicationContext applicationContext;

  @Override
  public void setBeanName(String beanName) {
    this.beanName = beanName;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.printf("Properties of %s has been set%n", beanName);
  }

  @Override
  public void embarkOnQuest() {
    System.out.printf("The knight with name %s and context %s embarks on a quest%n", beanName,
        applicationContext.getDisplayName());
  }

  @Override
  public void destroy() throws Exception {
    System.out.printf("The knight %s is being destoryed%n", beanName);
  }
}