<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
      <h2>Message info</h2>
      
      <ul>
        <li><span class="label">ID: </span><span class="content">${requestScope.message.id}</span></li>
        <li><span class="label">Content: </span><span class="content">${requestScope.message.content}</span></li>
        <li><span class="label">Date: </span><span class="content"><fmt:formatDate value="${requestScope.message.creationDate}" pattern="yyyy/MM/dd"/></span></li>
        <li><span class="label">User ID: </span><span class="content">${requestScope.message.userId}</span></li>
      </ul>
    </div>
    
    <div class="options">
      Go to <a href="${ctxPath}/user/${requestScope.userId}/messages">message list</a>
    </div> 
  </div>
  
  <div id="footer">
    &copy; 2013, Chirper Inc. All rights reserved.
  </div>
</body>
</html>
