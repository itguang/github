# Jquery实现Ajax应用

---
## 使用load()方法异步请求数据
---
使用load()方法通过Ajax请求加载服务器中的数据，并把返回的数据放置到指定的元素中，它的调用格式为：

    load(url,[data],[callback])

参数url为加载服务器地址，可选项data参数为请求时发送的数据，callback参数为数据请求成功后，执行的回调函数。

实例代码:
```js

<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>使用load()方法异步请求数据</title>
        <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js" type="text/javascript"></script>
        <link href="style.css" rel="stylesheet" type="text/css" />
    </head>    
    <body>
        <div id="divtest">
            <div class="title">
                <span class="fl">我最爱吃的水果</span> 
                <span class="fr">
                    <input id="btnShow" type="button" value="加载" />
                </span>
            </div>
            <ul></ul>
        </div>      
        <script type="text/javascript">
            $(function () {
                $("#btnShow").bind("click", function () {
                    var $this = $(this);//把button转换为Jquery对象
                    $("ul")
                    .html("<img src='Images/Loading.gif' alt=''/>")//在调用load()方法之前,给 ul 标签设置一张图片
                    .load("http://www.imooc.com/data/fruit_part.html",function(){
                        $this.attr("disabled", "true");
                    });//请求 http://www.imooc.com/data/fruit_part.html 的数据,并把返回的数据放到 ul 标签里面
                })
            });
        </script>
    </body>
</html>
```

> $(function(){...});的作用
> 

        这是JQuery的内置函数，这是JQuery的语法，$表示JQuery对象，可以有好几种用法。比如传递选择器字符串、页面对象等，如果直接传函数体进去，表示网页加载完毕后要执行的意思。和JAVASCRIPT原来的这个是一样的：
         window.onload=function(){ //执行函数}    
         相当于 $(document).ready(function(){ } ) 
        或者：
        <body onload="XXX">
        也是一个意思。


## 使用getJSON() 方法异步加载JSON数据 
---
使用getJSON()方法可以通过Ajax异步请求的方式，获取服务器中的数据，并对获取的数据进行解析，显示在页面中，它的调用格式为：

    jQuery.getJSON(url,[data],[callback])或$.getJSON(url,[data],[callback])

其中，url参数为请求加载json格式文件的服务器地址，可选项data参数为请求时发送的数据，callback参数为数据请求成功后，执行的回调函数。

示例代码:
```js
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>使用getJSON()方法异步加载JSON格式数据</title>
        <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js" type="text/javascript"></script>
        <link href="style.css" rel="stylesheet" type="text/css" />
    </head>  
    <body>
        <div id="divtest">
            <div class="title">
                <span class="fl">我最喜欢的一项运动</span> 
                <span class="fr">
                    <input id="btnShow" type="button" value="加载" />
                </span>
            </div>
            <ul></ul>
        </div>      
        <script type="text/javascript">
            $(function () {
                $("#btnShow").bind("click", function () {
                    var $this = $(this);
                   $.getJSON("http://www.imooc.com/data/sport.json",function(data){
                        $this.attr("disabled", "true");
                        $.each(data, function (index, sport) {
                            if(index==3)
                            $("ul").append("<li>" + sport["name"] + "</li>");
                        });
    
                    });
                })
            });
        </script>
    </body>
</html>
```
## 使用get()方法以GET方式从服务器获取数据
---
使用get()方法时，采用GET方式向服务器请求数据，并通过方法中回调函数的参数返回请求的数据，它的调用格式如下：

    $.get(url,[callback])

参数url为服务器请求地址，可选项callback参数为请求成功后执行的回调函数。
```js
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>使用get()方法以GET方式从服务器获取数据</title>
        <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js" type="text/javascript"></script>
        <link href="style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div id="divtest">
            <div class="title">
                <span class="fl">我的个人资料</span> 
                <span class="fr">
                    <input id="btnShow" type="button" value="加载" />
                </span>
            </div>
            <ul></ul>
        </div>    
        <script type="text/javascript">
            $(function () {
                $("#btnShow").bind("click", function () {
                    var $this = $(this);
                    $.get('http://www.imooc.com/data/info_f.php',function(data) {
                        $this.attr("disabled", "true");
                        $("ul").append("<li>我的名字叫：" + data.name + "</li>");
                        $("ul").append("<li>男朋友对我说：" + data.say + "</li>");
                    }, "json");
                })
            });
        </script>
    </body>
</html>
```
## 使用post()方法以POST方式从服务器发送数据
---
与get()方法相比，post()方法多用于以POST方式向服务器发送数据，服务器接收到数据之后，进行处理，并将处理结果返回页面，调用格式如下：

    $.post(url,[data],[callback])

参数url为服务器请求地址，可选项data为向服务器请求时发送的数据，可选项callback参数为请求成功后执行的回调函数。

## 使用ajax()方法加载服务器数据
---
使用ajax()方法是最底层、功能最强大的请求服务器数据的方法，它不仅可以获取服务器返回的数据，还能向服务器发送请求并传递数值，它的调用格式如下：

    jQuery.ajax([settings])或$.ajax([settings])

其中参数settings为发送ajax请求时的配置对象，在该对象中，url表示服务器请求的路径，data为请求时传递的数据，dataType为服务器返回的数据类型，success为请求成功的执行的回调函数，type为发送数据请求的方式，默认为get。

## 使用ajaxSetup()方法设置全局Ajax默认项
---
使用ajaxSetup()方法可以设置Ajax请求的一些全局性选项值，设置完成后，后面的Ajax请求将不需要再添加这些选项值，它的调用格式为：

    jQuery.ajaxSetup([options])或$.ajaxSetup([options])

可选项options参数为一个对象，通过该对象设置Ajax请求时的全局选项值。

如果需要提交到多个处理程序的话，单纯用ajax就不好实现，用ajaxSetup来设置公共部分的设置
![点击查看](http://img.mukewang.com/52dcdce60001de2604780449.jpg)


## 使用ajaxStart()和ajaxStop()方法
---
ajaxStart()和ajaxStop()方法是绑定Ajax事件。ajaxStart()方法用于在Ajax请求发出前触发函数，ajaxStop()方法用于在Ajax请求完成后触发函数。它们的调用格式为：

$(selector).ajaxStart(function())和$(selector).ajaxStop(function())

其中，两个方法中括号都是绑定的函数，当发送Ajax请求前执行ajaxStart()方法绑定的函数，请求成功后，执行ajaxStop ()方法绑定的函数。

例如，在调用ajax()方法请求服务器数据前，使用动画显示正在加载中，当请求成功后，该动画自动隐藏，如下图所示
![点击查看图片](http://img.mukewang.com/52dcfb3a0001746d06020435.jpg)

> 问:"ajaxStart()方法是不是应该对触发了ajax请求的元素进行绑定？"
>
    Query官方文档描述：无论什么时候，当一个AJAX请求将要被发送时，jQuery会检查当前是否还有其他活跃的(未完成的)AJAX请求。如果在进程中没有找到其他活跃的AJAX请求，jQuery就会触发ajaxStart事件。此时，通过ajaxStart()函数绑定的所有事件处理函数都将被执行。
    ajaxStart()为全局函数

