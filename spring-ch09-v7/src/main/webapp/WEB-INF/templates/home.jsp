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
      This application demonstrates basic aspects of Spring Security.
    </div>
    
    <chirp:getUsername var="username"/>
    
    <div class="options">
      <c:choose>
        <c:when test="${not empty username}">
          <ul>
            <li>Click <a href="${ctxPath}/color-list">here</a> to see a list of colors</li>
            <li>Click <a href="${ctxPath}/fruit-list">here</a> to see a list of fruits</li>
            <li>Click <a href="${ctxPath}/poem">here</a> to see a poem</li>
            <li>Click <a href="${ctxPath}/j_spring_security_logout">here</a> to logout</li>
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
