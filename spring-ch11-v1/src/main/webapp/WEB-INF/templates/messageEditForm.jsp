<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<fmt:formatDate var="creationDate" value="${requestScope.message.creationDate}" pattern="yyyy-MM-dd"/>

<!DOCTYPE html>
<html>
<head>
  <title>Edit Message</title>
  <meta charset="UTF-8"/>
  <link rel="stylesheet" href="${ctxPath}/static/css/reset.css"/>
  <link rel="stylesheet" href="${ctxPath}/static/css/main.css"/>
</head>
<body>
  <div id="header">
    <h1>Chirper</h1>
  </div>
  
  <div id="main">
    <h2>Edit Message</h2>
    
    <form action="${ctxPath}/message/${requestScope.message.id}" method="post">
      <input type="hidden" name="_method" value="put"/>
      <span class="label">ID</span><input type="text" name="id" value="${requestScope.message.id}" readonly="readonly"/><br/>   
      <span class="label">Content</span><textarea name="content" rows="5" cols="25">${requestScope.message.content}</textarea><br/>
      <span class="label">Creation Date</span><input type="text" name="creationDate" value="${creationDate}" readonly="readonly"/><br/>   
      <span class="label">User ID</span><input type="text" name="userId" value="${requestScope.message.userId}" readonly="readonly"/><br/>
      <input type="submit" value="Submit"/>
    </form>
  </div>
  
  <div id="footer">
    &copy; Chriper Inc, 2013. All rights reserved. 
  </div>
</body>
</html>
