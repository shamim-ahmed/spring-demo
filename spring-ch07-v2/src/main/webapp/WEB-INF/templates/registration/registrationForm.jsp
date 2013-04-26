<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<div id="main">
  <div class="nav">
    <a href="${pageContext.request.contextPath}">Home</a>
  </div>
  
  <form action="${pageContext.request.contextPath}/register" method="post">
    <span class="label">Username</span><input type="text" name="username"/><br/>
    <span class="label">Password</span><input type="password" name="password"/><br/>
    <span class="label">Receive Email</span><input type="checkbox" name="receiveEmail" value="receiveEmail" checked="checked"/><br/>
    <input type="submit" value="Submit"/>
  </form> 
</div>
