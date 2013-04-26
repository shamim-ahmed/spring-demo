<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
  <title><tiles:insertAttribute name="title"/></title>
  <meta charset="UTF-8"/>
  <script type="text/javascript" src="${pageContext.servletContext.contextPath}/static/js/jquery-1.9.0.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/reset.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css"/>
</head>
<body>
  <tiles:insertAttribute name="headerMarkup"/>
  <tiles:insertAttribute name="mainMarkup"/>
  <tiles:insertAttribute name="footerMarkup"/>
</body>
</html>