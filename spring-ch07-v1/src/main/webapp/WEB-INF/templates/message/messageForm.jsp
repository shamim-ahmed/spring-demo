<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty sessionScope.user}">
  <c:redirect url="/login-form"/>
</c:if>

<!DOCTYPE html>
<html>
<head>
  <title>Create Message</title>
  <meta charset="UTF-8"/>
  <script src="${pageContext.request.contextPath}/static/js/jquery-1.9.0.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/custom.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/reset.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css"/>
</head>
<body>
  <div id="header">
    <h1>Chirper</h1>
  </div>
  
  <div id="main">
    <h2>Create Message</h2>
    
    <form action="${pageContext.request.contextPath}/create-message" method="post">
      <input type="hidden" name="userId" value="${sessionScope.user.id}"/>     
      <span class="label">Content</span><textarea name="content" rows="5" cols="25"></textarea><br/>     
      <input type="submit" value="Submit"/>
    </form>
  </div>
  
  <div id="footer">
    &copy; Chriper Inc, 2013. All rights reserved. 
  </div>
</body>
</html>
