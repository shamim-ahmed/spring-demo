<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<fmt:formatDate var="joinDate" value="${requestScope.user.joinDate}" pattern="yyyy-MM-dd"/>

<!DOCTYPE html>
<html>
<head>
  <title>Edit User</title>
  <meta charset="UTF-8"/>
  <link rel="stylesheet" href="${ctxPath}/static/css/reset.css"/>
  <link rel="stylesheet" href="${ctxPath}/static/css/main.css"/>
</head>
<body>
  <div id="header">
    <h1>Chirper</h1>
  </div>
  
  <div id="main">
    <h2>Edit User</h2>
    
    <form action="${ctxPath}/user/${requestScope.user.id}" method="post">
      <input type="hidden" name="_method" value="put"/>
      <span class="label">ID</span><input type="text" name="id" value="${requestScope.user.id}" readonly="readonly"/><br/>
      <span class="label">Username</span><input type="text" name="username" value="${requestScope.user.username}" readonly="readonly"/><br/>
      <span class="label">Password</span><input type="password" name="password" value="${requestScope.user.password}"/><br/>
      <span class="label">Join Date</span><input type="text" name="joinDate" value="${joinDate}" readonly="readonly"/><br/>
      <span class="label">Receive Email</span><input type="checkbox" name="receiveEmail" <c:if test='${requestScope.user.receiveEmail == true}'>checked='checked'</c:if> /><br/>     
      <input type="submit" value="Submit"/>
    </form>
  </div>
  
  <div id="footer">
    &copy; Chriper Inc, 2013. All rights reserved. 
  </div>
</body>
</html>
