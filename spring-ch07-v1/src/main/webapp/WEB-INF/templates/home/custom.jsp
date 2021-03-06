<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>Welcome to Chirper !</title>
  <meta charset="UTF-8"/>
  <script type="text/javascript" src="${pageContext.servletContext.contextPath}/static/js/jquery-1.9.0.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/reset.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css"/>
</head>
<body>
  <div id="header">
    <h1>Chirper</h1>
  </div>
  
  <div id="main">
    <h2>Welcome, <c:out value="${sessionScope.user.username}"/> !</h2>
    
    <div class="messages">
      <h2>Your Recent Messages</h2>
      
      <c:choose>
        <c:when test="${not empty requestScope.messages}">
          <ul>
            <c:forEach var="msg" items="${requestScope.messages}">
              <li>
                <span class="content"><c:out value="${msg.content}"/></span> - 
                <span class="username"><c:out value="${msg.user.username}"/></span>
              </li>
            </c:forEach>
          </ul>
        </c:when>
        <c:otherwise>
          <p>You have not posted any message</p>
        </c:otherwise>
      </c:choose>
    </div>
    
    <div class="options">
      <p>You can <a href="${pageContext.request.contextPath}/message-form">post</a> a new message or <a href="${pageContext.request.contextPath}/logout">logout</a></p>      
    </div>
  </div>
  
  <div id="footer">
    &copy; Chriper Inc, 2013. All rights reserved. 
  </div>
</body>
</html>