# request.getRequestDispatcher(result).forward(request, response);   路径问题


## [页面转发引起文件路径失效](http://blog.csdn.net/kingherooo/article/details/17674769)


加入下面的代码
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
```

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
