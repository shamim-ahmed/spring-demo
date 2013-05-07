package org.spring.ch11.v2.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.spring.ch11.v2.client.util.MiscUtils;

public class App5 {
  public static void main(String... args) {
    HttpClient httpClient = new DefaultHttpClient();
    HttpPost httpPost = new HttpPost("http://localhost:8080/spring-ch11-v2-webapp/user");
    httpPost.addHeader("Accept", "text/plain");
    List<NameValuePair> requestParams = new ArrayList<>();
    requestParams.add(new BasicNameValuePair("username", "shamim"));
    requestParams.add(new BasicNameValuePair("password", "secret"));
    requestParams.add(new BasicNameValuePair("receiveEmail", "false"));
    
    HttpEntity responseEntity = null;
    
    try {
      HttpEntity formEntity = new UrlEncodedFormEntity(requestParams);
      httpPost.setEntity(formEntity);
      HttpResponse response = httpClient.execute(httpPost);
      StatusLine statusLine = response.getStatusLine();
      int statusCode = statusLine.getStatusCode();
      
      if (statusCode == 200) {
        responseEntity = response.getEntity();
        String result = EntityUtils.toString(responseEntity);
        System.out.println(result);
      } else {
        System.err.printf("The response code is %d%n", statusCode);
      }
    } catch (Exception ex) {
      ex.printStackTrace(System.err);
    } finally {
      MiscUtils.closeEntity(responseEntity);
    }
  }
}
