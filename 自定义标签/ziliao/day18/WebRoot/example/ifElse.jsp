<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.itcast.cn/jsp/tag/example" prefix="eitcast"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    pageContext.setAttribute("grade","B");
    %>
    <eitcast:choose>
	    <eitcast:when test="${grade=='A'}">
	    	优秀
	    </eitcast:when>
	    <eitcast:otherwise>
	    	一般般
	    </eitcast:otherwise>
    </eitcast:choose>
  </body>
</html>
