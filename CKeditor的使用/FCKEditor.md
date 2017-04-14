#[官方文档](http://docs.ckeditor.com/#!/guide/dev_installation)

#[Simple官方例子](http://sdk.ckeditor.com/index.html)

# [CKEditor CDN](http://cdn.ckeditor.com/)

# 什么是 CKEditor
> CKEditor is an online WYSIWYG editor that is used to edit HTML documents (or their fragments) in the browser.

在线的,所见即所得的,可以编辑html文档的,在浏览器的编辑器

> The "edit HTML documents" part means that the editor can be used to edit any HTML content, like website content (blog articles, blog comments, forum posts), e-mails, or things that you write in web forms. That is not all, however: CKEditor can also be used in all sorts of online applications, i.e. all those that use HTML as their source text format and are run in the browser!

1.它的输出格式只有 .html

2.它没有存储的功能.
## Use UTF-8

```To avoid problems with character encoding, use UTF-8 for your websites and your database. Just set the <meta> element for your pages to:```
```xml
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
```
or, if you are using the HTML5 DOCTYPE, to:
```xml
<meta charset="utf-8">
```

# [Loading CKEditor Script(加载CHeditor 脚本)](http://docs.ckeditor.com/#!/guide/dev_ckeditor_js_load)


``CKEditor is a JavaScript application. To load it, you need to include a single file reference in your page. If you installed CKEditor in the ckeditor directory in the root of your website, you need to insert the following code fragment into the <head> section of your page:``

```xml
<head>
    ...
    <script src="/ckeditor/ckeditor.js"></script>
</head>
```
# Creating Editor Instances(创建CHEDITOR实例)


## Classic Editing(经典模式)
![](http://docs.ckeditor.com/guides/dev_ckeditor_js_load/classic_example.png)


### Creating a Classic Editor with a Textarea

```In classic editing, CKEditor can work just like a <textarea> HTML element on your page. The editor offers a user interface to write, format, and work with rich text in a hassle-free manner, but the same content could be added (though not that easily) through a <textarea> element, requiring the user to type HTML code inside.```

```As a matter of fact, in this scenario CKEditor uses the <textarea> element to transfer its data to the server. The <textarea> element is invisible to the end user. In order to create an editor instance using this approach, you must first add a <textarea> element to the source code of your HTML page:```

可以把CKEDITOR的内容输出到一个textarea 元素中去,这样可以便于使用表单提交数据到服务器

```xml
<textarea name="editor1" id="editor1">&lt;p&gt;初始化editor内容.&lt;/p&gt;</textarea>
```
```Note that if you want to load data into the editor, for example from a database, you need to put that data inside the <textarea> element, just like the HTML-encoded <p> element in the example above. In this case the <textarea> element was named editor1. This name can be used in the server-side code later, when receiving the submitted data.```

译文: 注意如果你想加载数据到CKEDITOR 中,例如从数据库取数据放进去,你必须把数据放入一个 textarea 元素中去.

把一个HTML元素替换为 CK 很简单, 只需要用一个 CK 的实例,调用replace()方法即可
````js
<script>
    CKEDITOR.replace( 'editor1' );
</script>
```
```This script block must be included at any point after the <textarea> tag in the source code of the page. You can also call the CKEDITOR.replace method inside the <head> section, but in this case you will need to listen for the window.onload event:```

你也可以在 head 标签里面调用 CKEDITOR.replace() 方法,

```js
<script>
    window.onload = function() {
        CKEDITOR.replace( 'editor1' );
    };
</script>

```

### 完整例子

```html

<!DOCTYPE html>
<html>
<head>
    <title>CKEditor Classic Editing Sample</title>
    <!-- Make sure the path to CKEditor is correct. -->
    <script src="/ckeditor/ckeditor.js"></script>
</head>
<body>
    <form method="post">
        <p>
            My Editor:<br>
            <textarea name="editor1" id="editor1">&lt;p&gt;Initial editor content.&lt;/p&gt;</textarea>
            <script>
                CKEDITOR.replace( 'editor1' );
            </script>
        </p>
        <p>
            <input type="submit">
        </p>
    </form>
</body>
</html>

```

## Inline Editing(Inline模式)

![](http://docs.ckeditor.com/guides/dev_ckeditor_js_load/inline_example.png)

``Inline Editing is a new technology introduced in CKEditor 4 that allows you to select any editable element on the page and edit it in-place. As a result, the editor can be used to edit content that looks just like the final page.``


它是一个真正的所见即所得的编辑体验,你所看到的就是最终要显示的结果

```html
<div id="editor1" contenteditable="true">
    <h1>Inline Editing in Action!</h1>
    <p>The "div" element that contains this text is now editable.
</div>
```

要使用 Inline 模式,很简单,只需要调用  CKEDITOR.inline 方法即可
```html
<div id="editor1" contenteditable="true">
    <h1>Inline Editing in Action!</h1>
    <p>The "div" element that contains this text is now editable.
</div>
<script>
    // Turn off automatic editor creation first.
    CKEDITOR.disableAutoInline = true;
    CKEDITOR.inline( 'editor1' );
</script>
```
When you click inside the content of this <div> element, the CKEditor toolbar will appear.
当你点击div 这个元素的时候,CK将会出现

### Inline Editing for Textarea

``Since CKEditor 4.2 you can also turn <textarea> elements into inline editors. When you call the CKEDITOR.inline method on a <textarea>, an additional <div> element with inline editing enabled will replace the original <textarea>.``

## [Setting CKEditor Configuration](http://docs.ckeditor.com/#!/guide/dev_configuration)

# [CKEDITOR.config](http://docs.ckeditor.com/#!/api/CKEDITOR.config)(配置文件)

例如配置语言
```xml
config.contentsLanguage = 'fr';
```
# [CKEDITOR](http://docs.ckeditor.com/#!/api/CKEDITOR)(API带有例子)

## Defining Configuration In-Page

设置配置文件的最好的方式是在实例化 CK 的时候在页面中设置,这样的话,当你升级的时候不会出现问题

> In-page settings can be passed to any of the editor instance creation functions, namely CKEDITOR.replace and CKEDITOR.appendTo. For example:

### 1.有两个方法可以用 CKEDITOR.replace  和  CKEDITOR.appendTo

```html
CKEDITOR.replace( 'editor1', {
    language: 'fr',
    uiColor: '#9AB8F3'
});
注意:配置文件的语法格式,{configuration name : configuration value}

```

### 2.Using the config.js File(用config.js来修改配置)

```html
CKEDITOR.editorConfig = function( config ) {
    config.language = 'fr';
    config.uiColor = '#AADC6E';
};

```
`In order to apply the configuration settings, the CKEDITOR.editorConfig function must always be defined. The config.js file will be executed in the scope of your page, so you can also make references to variables defined in-page or even in other JavaScript files.`

### 3.Using a Custom Configuration File(自定义配置文件)
```Suppose you copied the config.js file to a folder named custom in the root of your website. You also renamed the file to ckeditor_config.js. At that point it is enough to only set the customConfig configuration option when creating the editor instances to use the customized settings defined in the file. For example:```
```html
CKEDITOR.replace( 'editor1', {
    customConfig: '/custom/ckeditor_config.js'
});
The custom configuration file must look just like the default config.js file.
```


# Content Filtering (ACF)

# Getting and Saving Data in CKEditor(得到和保存CK的数据)



> The CKEditor JavaScript API makes it easy to retrieve and control the data. Depending on your usage scenario(使用场景), the data can either be submitted to your server along with the parent <form> element or be used in Ajax applications where editor instances are created and destroyed dynamically.
> 

## Retrieving Data from CKEditor(得到数据)

```html
<script>
    var data = CKEDITOR.instances.editor1.getData();

    // Your code to save "data", usually through Ajax.
</script>
```
## Saving Data in CKEditor Replacing a Textarea

```When CKEditor functions as a replacement for a <textarea> element, the integration with the parent <form> element is automatic. CKEditor automatically updates the replaced <textarea> when the form is submitted, so there is no need to change any server-side code handling form submission after enabling CKEditor on an exisiting form element.```

`This means that when submitting a form containing an editor instance, its data will simply be posted to the server, using the <textarea> element name as the key to retrieve it.`

当一个textares 绑定了CKEDITOR时,点击提交按钮时,CK会自动提交数据到textarea,向使用普通textarea一样提交form表单

```Please note that the replaced <textarea> element is updated automatically by CKEditor straight before submission. If you need to access the <textarea> value programatically with JavaScript (e.g. in the onsubmit handler to validate the entered data), there is a chance that the <textarea> element would still store the original data. In order to update the value of replaced <textarea> use the editor.updateElement() method.```



```In rare cases it may happen that the server or application configuration will reject submitted HTML content if it is not encoded first (e.g. ASP.NET ValidateRequest). In such case check the config.htmlEncodeOutput option.```
在极少情况下会出现服务端拒绝提交的form表单,检查 config.htmlEncodeOutput

```If you need to get the actual data from CKEditor at any moment using JavaScript, use the editor.getData() method as described above```

### Observing Changes in CKEditor
**getData() returns CKEditor's HTML content.**
返回html内容

```html
var editor = CKEDITOR.replace( 'editor1' );

// The "change" event is fired whenever a change is made in the editor.
editor.on( 'change', function( evt ) {
    // getData() returns CKEditor's HTML content.
    console.log( 'Total bytes: ' + evt.editor.getData().length );
});
```
# [Example CKEditor Setups](http://docs.ckeditor.com/#!/guide/dev_example_setups)

##  配置CK 为编辑器(博客,文章,站点)

The Article Editor demo showcases an editor designed mainly for writing web text content like blog posts, articles etc.

Visit the [ckeditor-docs-samples](https://github.com/ckeditor/ckeditor-docs-samples/tree/master/editors) GitHub repository to learn more about this configuration.

## Document Editor

### Developer Site Editor
![](http://docs.ckeditor.com/guides/dev_example_setups/editor4.png)

#User Interface

## Setting Editor User Interface Color

```If you want to change the default UI color, you need to define the CKEDITOR.config.uiColor configuration setting which accepts an RGB color code.```

```html
config.uiColor = #66AB16;
```
[Setting Editor UI Color" sample ](http://sdk.ckeditor.com/samples/uicolor.html)
```html
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex, nofollow">
    <title>Setting editor UI color</title>
    <script src="http://cdn.ckeditor.com/4.6.2/standard-all/ckeditor.js"></script>
</head>

<body>

    <textarea cols="80" id="editor1" name="editor1" rows="10" >&lt;p&gt;This is some &lt;strong&gt;sample text&lt;/strong&gt;. You are using &lt;a href="http://ckeditor.com/"&gt;CKEditor&lt;/a&gt;.&lt;/p&gt;
    </textarea>

    <script>
        CKEDITOR.replace( 'editor1', {
            uiColor: '#CCEAEE'
        } );
    </script>
</body>

</html>
```
## Setting Editor User Interface Language

```html
config.defaultLanguage = 'de';
```

## Setting Editor Size
**注意后面没有单位px**

```html
config.width = 500;     // 500 pixels wide.
config.width = '75%';   // CSS unit (percent).

config.height = 500;        // 500 pixels high.
config.height = '25em';     // CSS unit (em).

```
```html
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex, nofollow">
    <title>Setting editor size</title>
    <script src="http://cdn.ckeditor.com/4.6.2/standard-all/ckeditor.js"></script>
</head>

<body>

    <textarea cols="80" id="editor1" name="editor1" rows="10" >&lt;p&gt;This is some &lt;strong&gt;sample text&lt;/strong&gt;. You are using &lt;a href="http://ckeditor.com/"&gt;CKEditor&lt;/a&gt;.&lt;/p&gt;
    </textarea>

    <script>
        CKEDITOR.replace( 'editor1', {
            width: '70%',
            height: 500
        } );
    </script>
</body>

</html>
```
## Automatic Editor Height Adjustment to Content(自动调整高度度)

    The CKEDITOR.config.autoGrow_minHeight option defines the minimum height that the editor will always assume, no matter how much content it includes.

    The CKEDITOR.config.autoGrow_maxHeight option can be set in order to prevent the situation where huge amounts of content will cause the editor to expand infinitely.

```html
config.extraPlugins = 'autogrow';
config.autoGrow_minHeight = 250;
config.autoGrow_maxHeight = 600;
```

```html
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex, nofollow">
    <title>Automatic editor height adjustment to content</title>
    <script src="http://cdn.ckeditor.com/4.6.2/standard-all/ckeditor.js"></script>
</head>

<body>

    <textarea cols="80" id="editor1" name="editor1" rows="10">      &lt;p&gt;This editor instance was configured to &lt;strong&gt;automatically adjust its height to content&lt;/strong&gt; that is added to it.&lt;/p&gt;      &lt;p&gt;&lt;strong&gt;Add some content here &lt;/strong&gt;to see &lt;strong&gt;how the editor expands&lt;/strong&gt; in order to fit it in.&lt;/p&gt;
    </textarea>

    <script>
        CKEDITOR.replace( 'editor1', {
            extraPlugins: 'autogrow',
            autoGrow_minHeight: 200,
            autoGrow_maxHeight: 600,
            autoGrow_bottomSpace: 50,
            removePlugins: 'resize'
        } );
    </script>
</body>

</html>
```

## [Editor Resizing Customization](http://docs.ckeditor.com/#!/guide/dev_resize)(编辑器的手动调整大小)

可以配置最小调整和最大调整大小

也可以配置 水平还是竖直方向上调整



### Disabling Editor Resizing

**To prevent the editor from being resized you can use the CKEDITOR.config.removePlugins setting to remove the Editor Resize (resize) plugin.**
```html
config.removePlugins = 'resize';
```
**You can also disable this feature by setting the CKEDITOR.config.resize_enabled configuration option to false.**
```html
config.resize_enabled = false;
```

```html
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex, nofollow">
    <title>Editor resizing customization</title>
    <script src="http://cdn.ckeditor.com/4.6.2/standard-all/ckeditor.js"></script>
</head>

<body>

    </textarea>

    <script>
        CKEDITOR.replace( 'editor1', {
            width: 600,
            height: 300,
            resize_dir: 'both',
            resize_minWidth: 200,
            resize_minHeight: 300,
            resize_maxWidth: 800
        } );
    </script>
</body>

</html>
```

## Creating Captioned Images(带标题的image)

```html
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex, nofollow">
    <title>Creating captioned images</title>
    <script src="http://cdn.ckeditor.com/4.6.2/standard-all/ckeditor.js"></script>
</head>

<body>

    <textarea cols="80" id="editor1" name="editor1" rows="10" >&lt;p&gt;This is some &lt;strong&gt;sample text&lt;/strong&gt;. You are using &lt;a href="http://ckeditor.com/"&gt;CKEditor&lt;/a&gt;.&lt;/p&gt;
    </textarea>

    <script>
        CKEDITOR.replace( 'editor1', {
            extraPlugins: 'image2',
            height: 450
        } );
    </script>
</body>

</html>
```

# Inserting Code Snippets(插入代码片段)

```html
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex, nofollow">
    <title>Using syntax highlighting</title>
    <script src="http://cdn.ckeditor.com/4.6.2/standard-all/ckeditor.js"></script>
</head>

<body>

    <textarea id="editor1" name="editor1" >
&lt;p&gt;JavaScript code:&lt;/p&gt;

&lt;pre&gt;
&lt;code class="language-javascript"&gt;var cow = new Mammal( "moo", {
    legs: 4
} );&lt;/code&gt;&lt;/pre&gt;

&lt;p&gt;Unknown markup:&lt;/p&gt;

&lt;pre&gt;
&lt;code&gt; ________________
/                \
| How about moo? |  ^__^
\________________/  (oo)\_______
                  \ (__)\       )\/\
                        ||----w |
                        ||     ||
&lt;/code&gt;&lt;/pre&gt;
    </textarea>

    <script>
        var config = {
            extraPlugins: 'codesnippet',
            codeSnippet_theme: 'monokai_sublime',//自定义主题: https://highlightjs.org/static/demo/
            height: 356
        };

        CKEDITOR.replace( 'editor1', config );
    </script>
</body>

</html>
```

## [图片上传](http://sdk.ckeditor.com/samples/fileupload.html#uploading-dropped-and-pasted-images)

## [Setting Text and Background Color](http://docs.ckeditor.com/#!/guide/dev_colorbutton)


```html
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex, nofollow">
    <title>Text and background color with Color Dialog</title>
    <script src="http://cdn.ckeditor.com/4.6.2/standard-all/ckeditor.js"></script>
</head>

<body>

    <textarea cols="80" id="editor1" name="editor1" rows="10" >&lt;p&gt;This is some &lt;strong&gt;sample text&lt;/strong&gt;. You are using &lt;a href="http://ckeditor.com/"&gt;CKEditor&lt;/a&gt;.&lt;/p&gt;
    </textarea>

    <script>
        CKEDITOR.replace( 'editor1', {
            height: 250,
            extraPlugins: 'colorbutton,colordialog'
        } );
    </script>
</body>

</html>
```
## The HTML Output Writer

``The HTML Output Writer plugin makes it possible to generate advanced output formatting with CKEditor.
``
``The writer is used by the CKEDITOR.htmlDataProcessor class to write output data. The current writer for a specific editor instance can be retrieved with the editor.dataProcessor.writer property.
``
``It is possible to configure several output formatting options by setting the writer properties. The following example summarizes the most common properties and gives their default values``


## Enter Key Configuration

``When CKEditor is integrated in some environments you may want to configure the default behavior of the Enter and Shift+Enter keys to generate matching output. This is possible thanks to CKEDITOR.config.enterMode and CKEDITOR.config.shiftEnterMode, respectively.``

```html
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex, nofollow">
    <title>Enter key configuration</title>
    <script src="http://cdn.ckeditor.com/4.6.2/standard-all/ckeditor.js"></script>
</head>

<body>

    <textarea cols="80" id="editor1" name="editor1" rows="10">      This is some sample text.
    </textarea>

    <script>
        CKEDITOR.replace( 'editor1', {
            // Pressing Enter will create a new <div> element.
            enterMode: CKEDITOR.ENTER_DIV,
            // Pressing Shift+Enter will create a new <p> element.
            shiftEnterMode: CKEDITOR.ENTER_P
        } );
    </script>
</body>

</html>
```
