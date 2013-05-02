<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <h1>Login Page</h1>
  </div>
    
  <div id="main">
    <div class="info">
      <h3>Login Form</h3>
      
      <form action="${ctxPath}/j_spring_security_check" method="post">
        <span class="label">Username</span><input type="text" name="j_username"/><br/>
        <span class="label">Password</span><input type="password" name="j_password"/><br/>
        <c:if test="${not empty param.error and param.error eq true}">
          <p class="error">Login failed</p>
        </c:if>
        <input type="submit" value="Submit"/>        
      </form>
    </div>
  </div>
  
  <div id="footer">
    &copy; 2013, Chirper Inc. All rights reserved.
  </div>
</body>
</html>
