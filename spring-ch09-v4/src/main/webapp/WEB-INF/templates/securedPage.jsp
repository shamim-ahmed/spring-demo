<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
  <title>Spring Security Demo</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/reset.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css"/>
</head>
<body>
  <div id="header">
    <h1>Spring Security Demo</h1>
  </div>
  
  <div id="main">
    <div class="info">
      <p>This page is secured. It contains top secret info :-)</p>
      
      <security:authorize access="isAuthenticated() and principal.username == 'shamim'">
        <p>Long time no see, Shamim !</p>
      </security:authorize>    
    </div>
    
    <div class="options">
      Go to <a href="${pageContext.request.contextPath}">Home</a>
    </div> 
  </div>
  
  <div id="footer">
    &copy; 2013, Chirper Inc. All rights reserved.
  </div>
</body>
</html>
