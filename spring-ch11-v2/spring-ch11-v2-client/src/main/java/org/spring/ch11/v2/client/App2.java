package org.spring.ch11.v2.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.spring.ch11.v2.client.util.MiscUtils;

public class App2 {
  public static void main(String... args) {
    HttpClient httpClient = new DefaultHttpClient();
    HttpGet httpGet = new HttpGet("http://localhost:8080/spring-ch11-v2-webapp/message/1");
    httpGet.addHeader("Accept", "application/json");
    
    HttpEntity httpEntity = null;
    
    try {
      HttpResponse response = httpClient.execute(httpGet);
      StatusLine statusLine = response.getStatusLine();
      int statusCode = statusLine.getStatusCode();
      
      if (statusCode == 200) {
        httpEntity = response.getEntity();
        String result = EntityUtils.toString(httpEntity);
        System.out.println(result);
      } else {
        System.err.printf("The status code is %d%n", statusCode);
      }
    } catch (Exception ex) {
      System.err.println(ex);
    } finally {
      MiscUtils.closeEntity(httpEntity);
    }
  }
}
