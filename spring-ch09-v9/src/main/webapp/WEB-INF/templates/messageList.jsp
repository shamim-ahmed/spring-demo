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
    <h1>Message Content</h1>
  </div>

  <div id="main">
    <div class="info">
      <h3>Content of Messages</h3>
      
      <c:forEach var="msg" items="${messages}">
        <p><c:out value="${msg.content}"/> - <c:out value="${msg.username}"/></p>
      </c:forEach>
    </div>
    
    <div class="options">
      Go to <a href="${ctxPath}">Home</a>
    </div>
  </div>
  
  <div id="footer">
    &copy; 2013, Chirper Inc. All rights reserved.
  </div>
</body>
</html>
