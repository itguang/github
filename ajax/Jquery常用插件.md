#Jquery常用插件

---

## 表单插件——form

通过表单form插件，调用ajaxForm()方法，实现ajax方式向服务器提交表单数据，并通过方法中的options对象获取服务器返回数据，调用格式如下：

    $(form). ajaxForm ({options})

其中form参数表示表单元素名称；options是一个配置对象，用于在发送ajax请求过程，设置发送时的数据和参数。

> ajaxForm()方法的应用?
    求解答:
    用ajaxForm()方法获取用户在注册时的个人信息

    在options中设置 url="后台接收存储数据的地址",   target="数据返回后的展示位置",就能实现,用户注册成功后在页面处显示个人的信息???

```js
    表单插件：form语法调用格式
    $(form).ajaxForm(options)
    form:表单元素名称：
    options：一个配置对象需要在前面进行设置：设置格式大概如下：
    var options = ｛
       url:“请求服务器的地址”，
       target：“服务器返回数据显示的地址”
    ｝

```

## 图片灯箱插件——lightBox

该插件可以用圆角的方式展示选择中的图片，使用按钮查看上下张图片，在加载图片时自

带进度条，还能以自动播放的方式浏览图片，调用格式如下：

    $(linkimage).lightBox({options})

其中linkimage参数为包含图片的<a>元素名称，options为插件方法的配置对象。

例如，以列表的方式在页面中展示全部的图片，当用户单击其中某张图片时，通过引入的图片插件，采用“灯箱”的方式显示所选的图片，如下图所示：
![点击查看图片](http://img.mukewang.com/52e488760001d36c05070495.jpg)

## 图片放大镜插件——jqzoom

在调用jqzoom图片放大镜插件时，需要准备一大一小两张一样的图片，在页面中显示小图片，当鼠标在小图片中移动时，调用该插件的jqzoom()

方法，显示与小图片相同的大图片区域，从而实现放大镜的效果，调用格式如下：

    $(linkimage).jqzoom({options})

其中linkimage参数为包含图片的<a>元素名称，options为插件方法的配置对象。

## cookie插件——cookie

使用cookie插件后，可以很方便地通过cookie对象保存、读取、删除用户的信息，还能通

过cookie插件保存用户的浏览记录，它的调用格式为：

保存：$.cookie(key，value)；读取：$.cookie(key)，删除：$.cookie(key，null)

其中参数key为保存cookie对象的名称，value为名称对应的cookie值。

例如，当点击“设置”按钮时，如果是“否保存用户名”的复选框为选中状态时，则使用cookie对象保存用户名，否则，删除保存的cookie用户名，如下图所示：

![点击查看图片](http://img.mukewang.com/52e49d8100016e2c06280481.jpg)

> 关于路径问题
 path: "/", expires: 7
能解释下代表的意思吗？
    如果你想在整个网站中访问这个cookie需要这样设置有效路径：path: '/'
    创建一个cookie并设置有效时间为7天: expires: 7


    ## 搜索插件——autocomplete

    搜索插件的功能是通过插件的autocomplete()方法与文本框相绑定，当文本框输入字符时，绑定后的插件将返回与字符相近的字符串提示选择，调用格式如下：

$(textbox).autocomplete(urlData,[options]);

其中，textbox参数为文本框元素名称，urlData为插件返回的相近字符串数据，可选项参数options为调用插件方法时的配置对象。

例如，当用户在文本框输入内容时，调用搜索插件的autocomplete()方法返回与输入内容相匹配的字符串数据，显示在文本框下，提示选择，如下图所示：
![点击查看图片](http://img.mukewang.com/52e49eb90001024606410464.jpg)

## 右键菜单插件——contextmenu

右键菜单插件可以绑定页面中的任意元素，绑定后，选中元素，点击右键，便通过该插件弹出一个快捷菜单，点击菜单各项名称执行相应操作，调用代码如下：

$(selector).contextMenu(menuId,{options});

Selector参数为绑定插件的元素，meunId为快捷菜单元素，options为配置对象。

## 自定义对象级插件——lifocuscolor插件

自定义的lifocuscolor插件可以在<ul>元素中，鼠标在表项<li>元素移动时，自定义其获取焦点时的背景色，即定义<li>元素选中时的背景色，调用格式为：

    

其中，参数Id表示<ul>元素的Id号，color表示<li>元素选中时的背景色。

例如，在页面中，调用自定义的lifocuscolor插件，自定义<li>元素选中时的背景色，如下图所示：
![点击查看图片](http://img.mukewang.com/52e4a100000199ac04200306.jpg)


