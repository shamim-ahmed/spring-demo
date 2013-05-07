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
      <h2>User info</h2>
      
      <ul>
        <li><span class="label">ID: </span><span class="content">${requestScope.user.id}</span></li>
        <li><span class="label">Username: </span><span class="content">${requestScope.user.username}</span></li>
        <li><span class="label">Join Date: </span><span class="content"><fmt:formatDate value="${requestScope.user.joinDate}" pattern="yyyy/MM/dd"/></span></li>
      </ul>
    </div>
    
    <div class="options">
      <p><a href="${ctxPath}/user/${requestScope.user.id}/edit-form">Edit</a> or <a href="${ctxPath}/user/${requestScope.user.id}/delete-form">Delete</a> this user</p>
      <br/>
      <p>Go to <a href="${ctxPath}/users">user list</a></p>
    </div> 
  </div>
  
  <div id="footer">
    &copy; 2013, Chirper Inc. All rights reserved.
  </div>
</body>
</html>
