package edu.buet.cse.spring.ch12.v5.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import edu.buet.cse.spring.ch12.v5.model.Tweet;
import edu.buet.cse.spring.ch12.v5.service.LoggingService;

public class LoggingServiceImpl implements LoggingService {
  private final Logger logger = LogManager.getLogger(getClass());
  
  @Override
  public void log(Tweet tweet) {
    logger.info(String.format("The logged tweet is :%s", tweet));
  }
}
