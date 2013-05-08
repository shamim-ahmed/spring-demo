<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>Spring JMX Integration Demo</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/reset.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css"/>
</head>
<body>
  <div id="header">
    <h1>Spring JMX Integration Demo</h1>
  </div>
  
  <div id="main">
    <h2>The set of generated numbers</h2>
    
    <ul>
      <c:forEach var="num" items="${requestScope.numbers}">
        <li>${num}</li>
      </c:forEach>
    </ul>
  </div>
  
  <div id="footer">
    &copy; 2013, Chirper Inc. All rights reserved.
  </div>
</body>
</html>
