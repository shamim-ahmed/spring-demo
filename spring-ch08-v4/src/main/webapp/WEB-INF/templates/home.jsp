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
      This application demonstrates how a simple web flow works.
    </div>
    
    <div class="options">
      <form action="${flowExecutionUrl}" method="post">
        To start the flow demo, click <a href="pizza-flow">here</a>
      </form>
    </div> 
  </div>
  
  <div id="footer">
    &copy; 2013, Chirper Inc. All rights reserved.
  </div>
</body>
</html>
