<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
  <title>Delete User</title>
  <meta charset="UTF-8"/>
  <link rel="stylesheet" href="${ctxPath}/static/css/reset.css"/>
  <link rel="stylesheet" href="${ctxPath}/static/css/main.css"/>
</head>
<body>
  <div id="header">
    <h1>Chirper</h1>
  </div>
  
  <div id="main">
    <h2>Delete User</h2>
    
    <form action="${ctxPath}/user/${requestScope.user.id}" method="post">
      <input type="hidden" name="_method" value="delete"/>
      <input type="hidden" name="id" value="${requestScope.user.id}"/>
      <p>Are you sure you want to delete the user with name ${requestScope.user.username} ?</p>
      <br/>
      <input type="submit" value="Yes"/>
      &nbsp;
      <input type="reset" value="No" onclick="window.location = '${ctxPath}/users'"/>
    </form>
  </div>
  
  <div id="footer">
    &copy; Chriper Inc, 2013. All rights reserved. 
  </div>
</body>
</html>
