<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.itcast.cn/jsp/tag/example" prefix="eitcast"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>模拟forEach，强大版本</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    pageContext.setAttribute("list",list);
    %>
    <eitcast:forEach2 items="${list}" var="s">
    	${s}<br/>
    </eitcast:forEach2>
    <hr/>
    <%
    Set set = new HashSet();
    set.add("aaaa");
    set.add("bbbb");
    set.add("cccc");
    pageContext.setAttribute("set",set);
    %>
    <eitcast:forEach2 items="${set}" var="s">
    	${s}<br/>
    </eitcast:forEach2>
    <hr/>
    <%
    Map map = new HashMap();
    map.put("a","aaaaa");
    map.put("b","bbbbb");
    map.put("c","ccccc");
    pageContext.setAttribute("map",map);
    %>
    <eitcast:forEach2 items="${map}" var="me">
    	${me.key}=${me.value}<br/>
    </eitcast:forEach2>
    <hr/>
    <%
    String strs[] = {"a","b","c"};
    pageContext.setAttribute("strs",strs);
    %>
    <eitcast:forEach2 items="${strs}" var="s">
    	${s}<br/>
    </eitcast:forEach2>
    <hr/>
     <%
   	int ii[] = {1,2,3,4};
    pageContext.setAttribute("ii",ii);
    %>
    <eitcast:forEach2 items="${ii}" var="s">
    	${s}<br/>
    </eitcast:forEach2>
    <hr/>
    <%
   	float ff[] = {1.0f,2,3,4};
    pageContext.setAttribute("ff",ff);
    %>
    <eitcast:forEach2 items="${ff}" var="s">
    	${s}<br/>
    </eitcast:forEach2>
  </body>
</html>
