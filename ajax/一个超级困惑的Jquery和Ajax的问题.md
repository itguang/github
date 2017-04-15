##Jquery作用域问题
写了一个简单的登陆界面,学习Jquery的Ajax应用,如下:
```html
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>AJax</title>
    <style>
        body, input, select, button, p {
            font-size: 28px;
            line-height:1.7;
        }
    </style>
</head>
<body>
    
    用户名:<input id="username" type="text"  style="width:200px"><br/><br/>
    密码  :  <input id="pwd" type="password" style="width:200px"><br/><br/>
    <button id="getsearch">get查询</button>
    <button id="postsearch">post查询</button>

    <p id="searchResult"></p>


    <script src="http://apps.bdimg.com/libs/jquery/1.11.1/jquery.js"></script>
    </body>
    </html>
```

然后我又写了Jquery代码如下:

```js

<script type="text/javascript">
        var username = $("#username").val();
        var pwd = $("#pwd").val();
        $(document).ready(function() {
            $("#getsearch").click(function() {

                $.ajax({ 
                    type: "GET",    
                    url: '/servlet大作业/servlet/JsonServlet?username='+username+'&pwd='+ pwd,
                    dataType: "json",
                    success: function(data) {
                        if (data.success) { 
                            $("#searchResult").html(data.msg);
                        } else {
                            $("#searchResult").html(data.msg);                      
                        }  
                    },
                    error: function(jqXHR){     
                        alert("发生错误：" + jqXHR.status);  
                    },     
                });
                });
            
        });
        </script>
```
注意上面代码的
```js
 var username = $("#username").val();
        var pwd = $("#pwd").val();
```
和
```js
 url: '/servlet大作业/servlet/JsonServlet?username='+username+'&pwd='+ pwd,
```
**然后接下来我自认为代码写的无比正确,然而令我出乎意料的事情出现了,测试的时候,却只能获取到username,而获取不到pwd.**

然后我又修改了以下代码:


```js
<script type="text/javascript">
       
        $(document).ready(function() {
            $("#getsearch").click(function() {
                 var username = $("#username").val();
                 var pwd = $("#pwd").val();

                $.ajax({ 
                    type: "GET",    
                    url: '/servlet大作业/servlet/JsonServlet?username='+username+'&pwd='+pwd,
                    dataType: "json",
                    success: function(data) {
                        if (data.success) { 
                            $("#searchResult").html(data.msg);
                        } else {
                            $("#searchResult").html(data.msg);                      
                        }  
                    },
                    error: function(jqXHR){     
                        alert("发生错误：" + jqXHR.status);  
                    },     
                });
                    });
            
        });
            </script>

```

再次测试,完美获取数据.

到这儿,我算是明白了,原来我是不懂 $(document).ready() 这个方法啊,

> 学习jQuery的第一件事是：如果你想要一个事件运行在你的页面上，你必须在$(document).ready()里调用这个事件。所有包括在$(document).ready()里面的元素或事件都将会在DOM完成加载之后立即加载，并且在页面内容加载之前。
> 

**但是话又说回来,为什么可以获取username的输入,却获取不到pwd的输入呢?????
此处困惑不解,望知情者留言解答**


参考链接[jquery $(document).ready() 与window.onload的区别](http://www.jb51.net/article/21628.htm)