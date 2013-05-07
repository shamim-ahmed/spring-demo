package org.spring.ch11.v2.client.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

public class MiscUtils {
  public static void closeEntity(HttpEntity entity) {
    if (entity == null) {
      return;
    }
    
    try {
      EntityUtils.consume(entity);
    } catch (IOException ex) {
      ex.printStackTrace(System.err);
    }
  }
  
  private MiscUtils() {
  }
}
