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
  	pageContext.setAttribute("gender","0");
  	%>
    <eitcast:if test="${gender=='1'}">
    	男
    </eitcast:if>
    <eitcast:if test="${gender=='0'}">
    	女
    </eitcast:if>
  </body>
</html>
