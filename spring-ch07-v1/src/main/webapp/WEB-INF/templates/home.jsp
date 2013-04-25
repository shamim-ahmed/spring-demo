<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>Welcome to Chirper !</title>
  <script type="text/javascript" src="${pageContext.servletContext.contextPath}/static/js/jquery-1.9.0.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/reset.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css"/>
</head>
<body>
  <div id="header">
    <h1>Chirper</h1>
  </div>
  
  <div id="main">
    <h2>Welcome to Chirper !</h2>
    
    <div class="info">
      Chirper is a microblogging site that allows you to post messages and see messages from other members. 
    </div>
    
    <div class="messages">
      <h3>Some recent messages</h3>
      
      <c:if test="${not empty requestScope.messages}">
        <ul>
          <c:forEach var="msg" items="${requestScope.messages}">
            <li>
              <span class="content"><c:out value="${msg.content}"/></span> - 
              <span class="username"><c:out value="${msg.user.username}"/></span>
            </li>
          </c:forEach>
        </ul>
      </c:if>
    </div>
  </div>
  
  <div id="footer">
    &copy; Chriper Inc, 2013. All rights reserved. 
  </div>
</body>
</html>