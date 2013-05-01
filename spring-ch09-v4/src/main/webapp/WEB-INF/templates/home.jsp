<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
  <title>Spring Security Demo</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/reset.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css"/>
</head>
<body>
  <div id="header">
    <h1>Spring Security Demo</h1>
  </div>
  
  <div id="main">
    <div class="info">
      <h2>This application demonstrates basic aspects of Spring Security</h2>
    </div>
    
    <security:authentication var="principal" property="principal"/>
    
    <%-- 
      Note : the following technique of accessing class name of a bean is interesting. However, in real world 
      projects it is better to write a separate tag to perform the test in a cleaner way.  
    --%>
    <c:set var="principalClassName" value="${principal.getClass().name}" />
    
    <c:if test="${principalClassName != 'java.lang.String'}">
      <security:authentication var="username" property="principal.username"/>
    </c:if>
    
    <div class="options">
      <c:choose>
        <c:when test="${not empty username}">
          <p>Welcome, <c:out value="${username}"/></p>
          
          <security:authorize access="hasRole('ROLE_USER')">
            <p>Your role is User</p>
          </security:authorize>
          
          <security:authorize access="hasRole('ROLE_ADMIN')">
            <p>Your role is Admin</p>
          </security:authorize>
          
          <security:authorize access="hasRole('ROLE_VISITOR')">
            <p>Your role is Visitor</p>
          </security:authorize>
          
          <p>To logout, click <a href="${pageContext.request.contextPath}/j_spring_security_logout">here</a></p>
        </c:when>        
        <c:otherwise>
          <p>To get started, please click on this <a href="${pageContext.request.contextPath}/secured-page">link</a></p>
        </c:otherwise>
      </c:choose>
    </div> 
  </div>
  
  <div id="footer">
    &copy; 2013, Chirper Inc. All rights reserved.
  </div>
</body>
</html>
