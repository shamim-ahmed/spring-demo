<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
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
    <h2>Login</h2>
    
    <form action="login" method="post">
      <span class="label">Username</span><input type="text" name="username"/><br/>
      <span class="label">Password</span><input type="password" name="password"/><br/>
      <input type="submit" value="Submit"/>
    </form>
  </div>
  
  <div id="footer">
    &copy; Chriper Inc, 2013. All rights reserved. 
  </div>
</body>
</html>
