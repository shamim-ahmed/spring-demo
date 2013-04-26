<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">
  <h2>Welcome to Chirper !</h2>
  
  <div class="info">
    Chirper is a microblogging site that allows you to post messages and see messages from other members. 
  </div>
  
  <div class="messages">
    <h2>Some Recent Messages</h2>
    
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
  
  <div class="options">
    To get started, please <a href="${pageContext.request.contextPath}/login-form">login</a> or <a href="${pageContext.request.contextPath}/register-form">register</a> .
  </div>
</div>