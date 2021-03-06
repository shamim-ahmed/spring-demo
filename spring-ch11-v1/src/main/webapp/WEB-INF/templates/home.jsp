<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
  <title>RESTful Spring Demo</title>
  <link rel="stylesheet" href="${ctxPath}/static/css/reset.css"/>
  <link rel="stylesheet" href="${ctxPath}/static/css/main.css"/>
</head>
<body>
  <div id="header">
    <h1>RESTful Spring Demo</h1>
  </div>
  
  <div id="main">
    <div class="info">
      This application demonstrates how to design a RESTful application with Spring.
    </div>
    
    <div class="options">
      <ul>
        <li>Click <a href="${ctxPath}/users">here</a> to view a list of users</li>
        <li>Click <a href="${ctxPath}/user-form">here</a> to create a user</li>
        <li>Click <a href="${ctxPath}/message-form">here</a> to create a message</li>
      </ul>
    </div> 
  </div>
  
  <div id="footer">
    &copy; 2013, Chirper Inc. All rights reserved.
  </div>
</body>
</html>
