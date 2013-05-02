<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
  <title>Spring Security Demo</title>
  <link rel="stylesheet" href="${ctxPath}/static/css/reset.css"/>
  <link rel="stylesheet" href="${ctxPath}/static/css/main.css"/>
</head>
<body>
  <div id="header">
    <h1>Spring Security Demo</h1>
  </div>
  
  <div id="main">
    <div class="info">
      <h2>This application demonstrates basic aspects of Spring Security</h2>
    </div>
    
    <div class="poem">
      <h3>How do I Love Thee ?</h3>
      
      <pre>
How do I love thee? Let me count the ways. 
I love thee to the depth and breadth and height 
My soul can reach, when feeling out of sight 
For the ends of being and ideal grace. 
I love thee to the level of every day's Most quiet need, by sun and candle-light. 
I love thee freely, as men strive for right. 
I love thee purely, as they turn from praise. 
I love thee with the passion put to use In my old griefs, and with my childhood's faith. 
I love thee with a love I seemed to lose With my lost saints. 
I love thee with the breath, Smiles, tears, of all my life; 
and, if God choose, I shall but love thee better after death.
      </pre>
    </div>
    
    <div class="options">
      Go to <a href="${pageContext.request.contextPath}">Home</a>
    </div> 
  </div>
  
  <div id="footer">
    &copy; 2013, Chirper Inc. All rights reserved.
  </div>
</body>
</html>
