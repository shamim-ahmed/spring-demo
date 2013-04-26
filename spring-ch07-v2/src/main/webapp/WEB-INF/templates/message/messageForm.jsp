<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<div id="main">
  <h2>Create Message</h2>
  
  <form action="${pageContext.request.contextPath}/create-message" method="post">
    <input type="hidden" name="userId" value="${sessionScope.user.id}"/>     
    <span class="label">Content</span><textarea name="content" rows="5" cols="25"></textarea><br/>     
    <input type="submit" value="Submit"/>
  </form>
</div>
