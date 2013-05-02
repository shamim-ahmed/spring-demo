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
    <h1>Message Form</h1>
  </div>

  <chirp:getUsername var="username"/>
      
  <div id="main">
    <div class="info">
      <h3>Message Form</h3>
  
      <c:if test="${not empty username}">
        <form action="${ctxPath}/message" method="post">
          <span class="label">Content</span><textarea name="content"></textarea><br/>
          <input type="hidden" name="username" value="${username}"/>
          <input type="submit" value="Submit"/>
        </form>
      </c:if>
    </div>
  </div>
  
  <div id="footer">
    &copy; 2013, Chirper Inc. All rights reserved.
  </div>
</body>
</html>
