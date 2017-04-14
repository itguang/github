#
#第一种方法: ${pageContext.request.contextPath}

```xml
<ul>
            <li><a href="index.jsp">首页</a></li>
            <li><a href="learn.jsp">个人博客</a></li>

            <li><a href="${pageContext.request.contextPath}/servlet/ItsourceController">IT资源</a></li>
            <li><a href="riji.jsp">个人日记</a></li>
            <li><a href="about.jsp">关于我</a></li>
            <li><a href="xc.jsp">相册展示</a></li>
            <li><a href="guestbook.jsp">留言板</a></li>
            <div class="clear"></div>
        </ul>
```


```xml
<a href="${pageContext.request.contextPath}/login.jsp" style="color:blue">登陆</a>
```

#第二种,配置bash 

## <base href="${bassPath}">


```xml

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    request.setAttribute("path", basePath);  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 <base href="${path}">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <base href="${bassPath}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登陆</title>

<link rel="stylesheet" href="css/login.css">

<script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
</head>
<body>
   
</body>
</html>

```
