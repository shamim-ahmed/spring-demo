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
    <div class="nav">
      <a href="${pageContext.request.contextPath}">Home</a>
    </div>
    
    <form action="${pageContext.request.contextPath}/register" method="post">
      <span class="label">Username</span><input type="text" name="username"/><br/>
      <span class="label">Password</span><input type="password" name="password"/><br/>
      <span class="label">Receive Email</span><input type="checkbox" name="receiveEmail" value="receiveEmail" checked="checked"/><br/>
      <input type="submit" value="Submit"/>
    </form> 
  </div>
  
  <div id="footer">
    &copy; Chriper Inc, 2013. All rights reserved. 
  </div>
</body>
</html>

