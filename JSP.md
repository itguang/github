# JSP

#指令(配置404错误默认页面)

**JSP的指令：3个**

page include tiglib

**配置全局错误页面**
```xml
        web.xml
        <error-page>
            <exception-type>java.lang.Exception</exception-type>
            <location>/error.jsp</location>
          </error-page>
          <error-page>
            <error-code>404</error-code>
            <location>/404.jsp</location>
          </error-page>
```
**配置单个JSP错误页面**
     errorPage指令：(转发技术)
 
1、作用：给JSP引擎用的（Tomcat）。不产生任何输出。

2、语法：<%@ 指令名称 指令属性1="值1" ...%>

> include指令:<%@ include file="head.jsp"%>  静态包含
> Servlet中能通过 request.getRequestDispatcher("url").forward(request,response)
> include行为:  <jsp:include flush="true" page="head.jsp" %>  动态包含

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

更多时候是使用setAttribution(String name,Object value) 将对象放置到request或session中.然后使用request.getRequestDispatcher().forward(request,response) 重定向,在重定向的页面(一般是 jsp 页面)可以获取这个属性.



**EL表达式**
```xml
    它只是JSP中的表达式，不是一种开发语言。

    基本语法：${EL表达式}

    4.1获取数据

        *****EL表达式只能获取四大域中的数据。

        EL表达式获取的对象如果是null，页面不会显示数据。因此，EL表达式中永远不

        会出现空指针异常

        p.name:调用域中名称为p对象的getName方法，点运算符是用于获取属性的取值的。               
            .运算符：
            []运算符：

            .运算符能做的，[]也能做。[]能做的，.不一定能做。
                比如${p.name}===${p['name']}==${p["name"]}
                
                优秀在可以取不符合Java命名规范的东东。
```

4.2数学逻辑运算:
        empty运算符：如果判断的对象是null或者空字符串，都返回true。对于集合，即

        使集合对象本身不是null，没有任何元素，也返回true。
        
        EL表达式不支持字符串连接操作。
        
### EL表达式获取JSP的内置对象（11大EL内置对象）：难点，不要与JSP的内置对象和范围名称搞混

**pageContext用来获取其余jsp对象**

        11大EL隐式对象中，其中一个是表示自身对象外，其余都是表示的Map结构
        
        EL隐式对象名称            Java类型                                  备注
        pageContext             javax.servlet.jsp.PageContext               与JSP中的内置对象完全相同
        
        剩余的都是代表的Map集合
        pageScope               java.util.Map                               代表着PageContext页面范围域那个Map

        requestScope            java.util.Map                               代表着ServletRequest请求范围域那个Map

        sessionScope            java.util.Map                               代表着HttpSession会话范围域那个Map

        applicationScope        java.util.Map                               代表着ServletContext应用范围域那个Map
        
        param                   java.util.Map                               代表着请求参数。key：请求参数的名称。value：请求参数的值，它是一个字符串。
        paramValues             java.util.Map                               代表着请求参数。key：请求参数的名称。value：请求参数的值，它是一个字符串数组。
        
        header                  java.util.Map                               代表着请求消息头。key：头名称。value：头值，它是一个字符串。
        headerValues            java.util.Map                               代表着请求消息头。key：头名称。value：头值，它是一个字符串数组。
  
   
                cookie                  java.util.Map                               代表客户端提交的Cookie的Map。key：cookie的name。value：cookie对象本身
```xml
<!-- 取JSESSIONID这个cookie的名字  -->
        ${cookie["JSESSIONID"].name }<br/>
        <!--取JSESSIONID这个cookie的值-->
        ${cookie.JSESSIONID.value}
```
        initParam               java.util.Map                               代表着全局初始化参数（web.xml中context-param）.key：参数名称。value：参数值
   


    4.4调用普通类的静态方法（EL函数）
        编写步骤（自定义EL函数的编写步骤即自定义标签的编写步骤）：
            a、编写一个普通的java类，提供一个静态方法
```java
            public class FunctionDemo {
                public static String toUpperCase(String str){
                    return str.toUpperCase();
                }
            }
```
            b、在JavaWeb应用的WEB-INF目录下建立一个扩展名是tld(taglib definition)的XML文件（参考Tomcat中的示例）。内容如下：
```xml
            <?xml version="1.0" encoding="UTF-8"?>
            <taglib xmlns="http://java.sun.com/xml/ns/j2ee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-jsptaglibrary_2_0.xsd"
                version="2.0">
                <tlib-version>1.0</tlib-version>
                <short-name>myfn</short-name>
                <uri>http://www.itcast.cn/myfn</uri>
                <function><!-- 定义函数 -->
                    <name>toUppercase</name>
                    <function-class>cn.itcast.el.FunctionDemo</function-class>
                    <function-signature>java.lang.String toUpperCase( java.lang.String )</function-signature>
                </function>
            </taglib>
```
            c、（可选步骤）前提是把tld文件放到了WEB-INF目录下。
            告知应用，tld文件和tld中的uri的对应。修改web.xml，增加以下内容：
```xml
            <jsp-config>
                <taglib>
                    <taglib-uri>http://www.itcast.cn/myfn</taglib-uri>
                    <taglib-location>/WEB-INF/myfn.tld</taglib-location>
                </taglib>
              </jsp-config>
```
            d、在JSP中使用
                用taglib指令，引入自定义的EL函数库
```xml
                <%@ taglib uri="http://www.itcast.cn/myfn" prefix="myfn"%>
                 ${myfn:toUppercase(p)}
```

## JSTL中的核心标签库(替换掉JSP中的Java脚本)

    c:if
        作用：判断是否为true，如果为true，那么标签的主体内容就会显示。
        属性：
            test：必须的。要求必须是boolean的。支持表达式（EL或Java表达式）
            var：保存test运算结果的变量
            scope: 保存的域范围。默认是page

            
    c:forEach
        遍历：数组、List、Set、Map
        属性：
            items：要遍历的目标对象。支持表达式
            var：变量名。指向当前遍历的集合中的一个元素
            begin：开始的索引（含）
            end：结束的索引（含）
            step：步长。默认是1
            varStatus：取一个名字，引用了一个对象。
                该对象有以下方法：
                    int getIndex():当前记录的索引号。从0开始
                    int getCount():当前记录的顺序。从1开始
                    boolean isFirst():是否是第一条记录
                    boolean isLast():是否是最后一条记录
            



## EL表达式可以读取JSP页面隐藏对象的属性

    ${pageScope.Person.age}

    ${pageScope.Person.age}

    ${session.person.age}

    ${application.person.age}


> 还有一种不带任何前缀的,就是前面说的 ${persion.age} 这种写法,
> 会现在request中查找,如果没有再在session中查找

### 登陆实例

```jsp
${empty sessionScope.user?"请登录":"欢迎您"}${sessionScope.user.name}
```
```jsp
<c:if test="${sessionScope.user==null}">
        <a href="${pageContext.request.contextPath}/login.jsp">登录</a>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/regist.jsp">还木有账号</a>
    </c:if>
    <c:if test="${sessionScope.user!=null}">
        欢迎您：${sessionScope.user.nick==""?sessionScope.user.username:sessionScope.user.nick}&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/servlet/CenterController?operation=logout">注销</a>
    </c:if>
```
**${pageContext.request.contextPath}**
```jsp
 <body>
    ${formBean.errors.message }
    <form action="${pageContext.request.contextPath}/servlet/CenterController?operation=login" method="post">
        *用户名：<input type="text" name="username" value="${formBean.username }"/>${formBean.errors.username }<br/>
        *密码：<input type="password" name="password" value=""/>${formBean.errors.password }<br/>
        <input type="submit" value="登录"/>
    </form>
  </body>
```
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
