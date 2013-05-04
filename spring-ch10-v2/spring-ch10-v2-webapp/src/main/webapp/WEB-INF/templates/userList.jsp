<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
  <title>Spring Remoting Demo</title>
  <link rel="stylesheet" href="${ctxPath}/static/css/reset.css"/>
  <link rel="stylesheet" href="${ctxPath}/static/css/main.css"/>
</head>
<body>
  <div id="header">
    <h1>Spring Remoting Demo</h1>
  </div>
  
  <div id="main">
    <div class="info">
      <h2>User List</h2>
      <ul>
        <c:forEach var="user" items="${users}">
          <li><c:out value="${user.username}"/></li>
        </c:forEach>
      </ul>
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
