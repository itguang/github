<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.itcast.cn/jsp/tag/simple" prefix="sitcast"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>控制jsp页面内容重复执行。</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
 
  <body>
  	<!-- 让标签的主体内容重复执行3次 -->
   	<sitcast:demo4 count="<%=1+2 %>"><hr/></sitcast:demo4>
  </body>
</html>
