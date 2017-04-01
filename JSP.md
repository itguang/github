# JSP

#指令

> include指令:<%@ include file="head.jsp"%>
> Servlet中能通过 request.getRequestDispatcher("url").forward(request,response)
> include行为:  <jsp:include flush="true" page="head.jsp" %>

# 四大作用域(scope): page   request   session    application 


# JSP配置多个映射地址
```xml
<servlet-mapping>
    <servlet-name>LoginServlet</servlet-name>
    <url-pattern>/servlet/LoginServlet</url-pattern>
  </servlet-mapping>
```

添加
```xml
<servlet-mapping>
    <servlet-name>LoginServlet</servlet-name>
    <url-pattern>/servlet/LoginServlet</url-pattern>
    <url-pattern>/servlet/LoginServlet.html</url-pattern>
    <url-pattern>/servlet/LoginServlet.php</url-pattern>
  </servlet-mapping>
```

#JSP内置对象

## out


## request

> 代表客户端的请求,代表客户端信息,以及请求信息

### 属性方法

> setAttribute(String name,Object value) 

在request中保存一个对象,本页面或forward(request,response) 之后的页面可以通过getAttribute(String name) 取得

> Dispatcher getRequestDispatcher():  请求转发
> response.sendRedirect(url)       : 请求重定向

返回Dispatcher对象,Dispatcher对象可以执行forward() 操作

> HttpSession getSession()

返回HttpSession 对象

> response

代表服务端的响应

> config

web.xml文件的初始化参数可以通过config的getInitParameter(String name) 获取
> session



> application

整个web应用程序对应一个application对象

> page

代表当前JSP页面,是当前编译后的Servlet对象,  this

> pageContext

能够获取到JSP中的资源

> exception

略



# EL表达式

EL表达式提供了获取对象以及属性的简单行为,某些情况下 EL表达式可以完全代替JSP脚本或者JSP行为

如: 可以将一个封装好的bean对象 User 放置到request中,在使用EL表达式读取该对象.
    EL表达式也可以获取session 中的对象,如果request中没有 User 这个对象,就会在 session 中查找

更多时候是使用setAttribution(String name,Object value) 将对象放置到request或session中.然后使用request.getDispatcher().forward(request,response) 重定向,在重定向的页面(一般是 jsp 页面)可以获取这个属性.

## EL表达式可以读取JSP页面隐藏对象的属性

${pageScope.Person.age}

${pageScope.Person.age}

${session.person.age}

${application.person.age}


> 还有一种不带任何前缀的,就是前面说的 ${persion.age} 这种写法,
> 会现在request中查找,如果没有再在session中查找

# Cookie机制

原理:

> cookie其实是一小段的文本信息.客户端请求服务器,如果该服务器需要记住该用户的状态,就向科幻浏览器颁发一个Cookie,
> 客户浏览器会把cookie保存起来.当浏览器再次请求网站时,浏览器会把请求的网址和cookie一同提交给服务器,服务器检查cookie,以此来辨别用户状态,服务器还可以根据需要修改cookie的内容

## 操作cookie

服务器通过操作cookie对象 对客户端cookie 进行操作.

通过 request.getCookie()获取客户端提交的所有Cookie(以cookie[] 数组的形式返回),

通过 response.addCookie(Cookie cookie) 向客户端设置 Cookie

**Cookie对象使用 key-value 属性对的形式保存用户状态,一个Cookie对象保存一个属性对.**


## Cookie 编码

Cookie中保存中文只能编码

Cookie应该在服务端创建,通过response 返回给客户端浏览器

```java
Cookie cookie1  = new Cookie(URLEncoder.encode("姓名","UTF-8"),URLEncode.encode("李小光","UTF-8"));
Cookie cookie2  = new Cookie(URLEncoder.encode("住址","UTF-8"),URLEncode.encode("河南","UTF-8"));

response.addCookie(cookie1);
response.addCookie(cookie2);
```
从cookie中取出信息

```java
Cookie cookie[] = request.getCookies();
//遍历cookie数组就行了

```

## Cookie不可跨域名性

html点击事件
```js
<input type = "button" value="刷新" onclick="location='setcookie.jsp'"/>
```
## Cookie的有效期
默认值为 -1,关闭浏览器Cookie消失

知识点

```java
<c: if test="${}">
...
</c>

<c: foreach var=" " items = " ">
...
0</c>

```

## cookie的修改和删除

cookie并不提供修改和删除的操作,如果要修改某个cookie,只需要新建一个同名的cookie,并添加到response中,覆盖原来的cookie即可

如果要删除一个cookie,只需要新建一个同名的cookie,并将maxAge属性设置为0,并添加到response中覆盖原来的那个cookie


# Session 机制

原理

> session是另一种记录客户状态的机制,不同的是Cookie保存在科幻断浏览器中,
> 而session保存在服务端浏览器中. 
> 
> 客户端在访问浏览器的时候,浏览器把客户的信息以某种形式记录在服务器上.
> 这就是Session.客户端浏览器再次访问,只需要从该session中查找客户的状态就行了


```java
Session对象是在客户端第一次请求服务器的时候创建.每个来访者对应一个session对象,
所有的客户状态都保存在这个 session 对象里, 

Session也是一种 key-value 的属性对,通过getAttribution(String key) 和 
setAttribution(String key,Object value) 的方法读写客户状态信息,

HttpSession session = request.getSession(); //获取session对象
session.setAttribute("LongTime",new date()); //设置session中的属性
out.println((Date)session.getAttribution("LongTime"));


```
## Session的生命周期

## session中的属性方法

```java
setAttribution(String name,Object value);
getAttribution(String name);
removeAttribution(String name);//移除该属性
invalidate(); //是该session失效

```

# Session 与 Cookie 的比较

1. Cookie中不能直接存取 java对象
