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
      <h2>Message List</h2>
      
      <ul>
        <c:forEach var="message" items="${requestScope.messages}">
          <li><a href="${ctxPath}/message/${message.id}"><c:out value="${message.content}"/></a></li>
        </c:forEach>
      </ul>
    </div>
    
    <div class="options">
      Go to <a href="${ctxPath}">Home</a>
    </div> 
  </div>
  
  <div id="footer">
    &copy; 2013, Chirper Inc. All rights reserved.
  </div>
</body>
</html>
