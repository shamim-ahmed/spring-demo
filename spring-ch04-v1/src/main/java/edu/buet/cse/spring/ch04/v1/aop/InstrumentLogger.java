package edu.buet.cse.spring.ch04.v1.aop;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class InstrumentLogger {
  private final Logger logger = LogManager.getLogger(getClass());
  
  public void beforeUse() {
    logger.info("An instrument is going to be used");
  }
  
  public void afterUse() {
    logger.info("Instrument use is complete");
  }
}
