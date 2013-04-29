<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <title>Spring Flow Demo</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/reset.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css"/>
</head>
<body>
  <div id="header">
    <h1>Spring Flow Demo</h1>
  </div>
  
  <div id="main">
    <div class="info">
      <h2 class="warning">Warning</h2>
    </div>
    
    <div class="options">
      <form action="${flowExecutionUrl}" method="post">
        <p>Delivery is not available in ${user.city}. You have to collect the pizza yourself</p>
        <button type="submit" name="_eventId_next">OK</button>
        &nbsp;
        <button type="submit" name="_eventId_cancel">Cancel</button>
      </form>
    </div>
  </div>
  
  <div id="footer">
    &copy; 2013, Chirper Inc. All rights reserved.
  </div>
</body>
</html>
