<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="chirp" uri="http://www.example.com/chirper" %>

<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
  <title>Spring Security Demo</title>
  <link rel="stylesheet" href="${ctxPath}/static/css/reset.css"/>
  <link rel="stylesheet" href="${ctxPath}/static/css/main.css"/>
</head>
<body>
  <div id="header">
    <h1>Spring Security Demo</h1>
  </div>
  
  <div id="main">
    <div class="info">
      <h2>This application demonstrates basic aspects of Spring Security.</h2>
    </div>
    
    <chirp:getUsername var="username"/>
    
    <div class="options">
      <c:choose>
        <c:when test="${not empty username}">
          <ul>
           <li><a href="${ctxPath}/message-list">List of messages</a></li>
           <li><a href="${ctxPath}/message-form">Create a message</a></li>
           <li><a href="${ctxPath}/message-search-form">Find a message</a></li>
          </ul>
        </c:when>
        <c:otherwise>
          <p>Click <a href="${ctxPath}/login-form">here</a> to login.</p>
        </c:otherwise>
      </c:choose>
    </div> 
  </div>
  
  <div id="footer">
    &copy; 2013, Chirper Inc. All rights reserved.
  </div>
</body>
</html>
