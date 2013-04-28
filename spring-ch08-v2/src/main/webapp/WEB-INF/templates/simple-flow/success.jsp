<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <title>Spring Flow Demo</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/reset.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css"/>
</head>
<body>
  <div id="header">
    <h1>Spring Flow Demo</h1>
  </div>
  
  <div id="main">
    <div class="info">
      <h2>You've reached the Success page</h2>
    </div>
    
    <div class="userDetails">
      <span class="label">Username: </span><span>${user.username}</span><br/>
      <span class="label">Password: </span><span>${user.password}</span><br/>
      <span class="label">Email: </span><span>${user.email}</span>
    </div>
    
    <div class="options">
      <p>Please go back to <a href="${pageContext.request.contextPath}">home</a></p>
    </div> 
  </div>
  
  <div id="footer">
    &copy; 2013, Chirper Inc. All rights reserved.
  </div>
</body>
</html>
