<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL 核心标签的使用</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <br/>----------c:out输出内容到页面上---------------<br/>
    <%
    pageContext.setAttribute("data","hello<hr/>");
    %>
    <c:out value="${data}" escapeXml="true"></c:out><br/>
    <c:out value="${data1}" default="木有值"></c:out><br/>
    ${data1 }
    <br/>----------c:set把某些对象绑定到域中---------------<br/>
    <c:set var="s" value="hello itcast" scope="page"></c:set>
    ${s}
    <br/>----------c:set设置JavaBean的属性值---------------<br/>
    <jsp:useBean id="p1" class="cn.itcast.domain.Person"></jsp:useBean>
    ${p1.name}
    <c:set value="朱巧玲" property="name" target="${p1}"></c:set>
    <%--
    p1.setName("朱巧玲");
     --%>
    ${p1.name}
    <br/>----------c:set设置Map对象的key和value---------------<br/>
    <%
    pageContext.setAttribute("map",new HashMap());
    %>
    <c:set value="I am value" property="I am key" target="${map}"></c:set>
    <c:forEach items="${map}" var="me">
    	${me.key}=${me.value}<br/>
    </c:forEach>
    <c:catch var="e"><!-- e就是引用异常对象的名称 -->
    <%=1/0 %>
    </c:catch>
    <%--
    try{
    	System.out.println(1/0);
    }catch(Exception e){
    	//相当于这里
    }
    --%>
    ${e.message}
    <hr/>
    <br/>-------------c:choose c:when c:otherwise等同if else ------------------<br/>
    <br/>--------------choose无法单独使用，只是作为when和otherwise的父标签存在的；------------------<br/>
    <br/>--------------when和otherwise必须出现在choose中；------------------<br/>
    <br/>--------------choose中可以只有when，但不可以只有otherwise------------------<br/>
    <br/>--------------choose中可以多个when，但只能有一个otherwise或者没有。有otherwise必须出现when的最后面------------------<br/>
    <c:set value="F" var="grade" scope="page"></c:set>
    <c:choose>
    	<c:when test="${grade=='A'}">
    		优秀
    	</c:when>
    	<c:when test="${grade=='B'}">
    		良好
    	</c:when>
    	<c:when test="${grade=='C'}">
    		一般
    	</c:when>
    	<c:when test="${grade=='D'}">
    		刚及格
    	</c:when>
    	<c:otherwise>
    		差极了
    	</c:otherwise>
    </c:choose>
    <hr/>
    <br/>--------c:import动态包含，如同jsp:include-------------<br/>
    <br/>------------c:url组织url字符串.不指定var属性会把value的值直接打到页面上-----------------------<br/>
    <br/>------------c:url能进行url重写-----------------------<br/>
    <br/>------------c:param就是传递参数。还能对不安全的字符进行url编码-----------------------<br/>
    <c:url value="/example/result.jsp" var="uu" scope="page">
    	<c:param name="content" value="你好"></c:param>
    </c:url>
    <%--
    pageContext.setAttribute("uu","/example/bbs.jsp");
    --%>
    <a href="${uu}">猛点</a>
    <br/>
    <c:forTokens items="2013-09/08" delims="-/" var="s">
    	${s }<br/>
    </c:forTokens>
  </body>
</html>
