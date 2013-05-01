<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="chirp" uri="http://www.example.com/chirper" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
      This application demonstrates basic aspects of Spring Security.
    </div>
    
    <chirp:getUsername var="username"/>
    
    <div class="options">
      <c:choose>
        <c:when test="${not empty username}">
          Welcome, <c:out value="${username}"/>. To logout, click <a href="${pageContext.request.contextPath}/j_spring_security_logout">here</a>
        </c:when>
        <c:otherwise>
          To get started, please click on this <a href="${pageContext.request.contextPath}/secured-page">link</a>
        </c:otherwise>
      </c:choose>
    </div> 
  </div>
  
  <div id="footer">
    &copy; 2013, Chirper Inc. All rights reserved.
  </div>
</body>
</html>
