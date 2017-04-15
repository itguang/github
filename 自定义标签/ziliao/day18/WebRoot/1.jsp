<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.itcast.cn/jsp/jstl" prefix="itcast"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>自定义标签入门：输出客户机的IP地址</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<!-- 实际开发中JSP中是不应该出现java脚本 -->
    <%--
    String remoteIp = request.getRemoteAddr();
    out.write(remoteIp);
    --%>
    您的IP地址是：<itcast:showRemoteIp/>
  </body>
</html>
