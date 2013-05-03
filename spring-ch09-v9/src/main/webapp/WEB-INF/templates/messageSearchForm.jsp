<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="chirp" uri="http://www.example.com/chirper" %>

<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
  <title>Spring Security Demo</title>
  <link rel="stylesheet" href="${ctxPath}/static/css/reset.css"/>
  <link rel="stylesheet" href="${ctxPath}/static/css/main.css"/>
  <script type="text/javascript" src="${ctxPath}/static/js/jquery-1.9.0.js"></script>
  <script type="text/javascript">
    $(document).ready(function() {
	  $("button[type='submit']").click(function() {
	    var id = $.trim($("input[name='id']").val());

	    if (id != '') {
	      document.location.href = '${ctxPath}/message/' + id;
	    }
	  });
	});
  </script>
</head>
<body>
  <div id="header">
    <h1>Message Search Form</h1>
  </div>

  <chirp:getUsername var="username"/>
      
  <div id="main">
    <div class="info">
      <h3>Message Id Form</h3>
  
      <c:if test="${not empty username}">
        <span class="label">Content</span><input type="text" name="id"/><br/>
        <button type="submit">Submit</button>
      </c:if>
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
