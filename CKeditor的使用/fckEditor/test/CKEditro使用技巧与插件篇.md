# 插件

## [File Upload through Dialogs and Drag&Drop](http://docs.ckeditor.com/#!/guide/dev_file_upload)


> This article is about the editor-server configuration for pasted and dropped files since it uses a different API than the File Browser plugin.

```html
config.extraPlugins = 'uploadimage';  //插件
config.uploadUrl = '/uploader/upload.php'; //上传文件到服务端.服务端处理

```
```html
config.extraPlugins = 'uploadimage';
config.imageUploadUrl = '/uploader/upload.php?type=Images';
```

## CK上传的文件与服务端如何交流
首先你需要一个服务端的应用程序接受上传的文件,这个应用程序不是 Ckeditor的一部分,
因此,你必须确保两端使用相同的API来进行交流.当然你也可以自己实现一套api来配合ckeditor来使用.下面简要介绍一下

### Server-Side Configuration(服务端配置)

#### Request

The default request for file uploads is a file as a form data with the 'upload' field.

默认一个文件使用表单form进行提交
####Response: 
File Uploaded Successfully

When the file is uploaded successfully, a JSON response with the following entries is expected:

服务端如果接受了文件之后,需要返回一个json 格式的数据告诉CKeditor

* uploaded – Set to 1.

* fileName – The name of the uploaded file.
 
* url – The URL to the uploaded file (URL-encoded).

例如:

```js
{
    "uploaded": 1,
    "fileName": "foo.jpg",
    "url": "/files/foo.jpg"
}
```
当然,有成功也有失败,你也可以返回一个失败信息的json数据

例如:

```js
{
    "uploaded": 1,
    "fileName": "foo(2).jpg",
    "url": "/files/foo(2).jpg",
    "error": {
        "message": "A file with the same name already exists. The uploaded file was renamed to \"foo(2).jpg\"."
    }
}
```

#### Response: File Could Not Be Uploaded

如果文件上传失败,也要返回一个json数据

* uploaded – Set to 0.

* error.message – The error message to display to the user.

```js
{
    "uploaded": 0,
    "error": {
        "message": "The file is too big."
    }
}
```
### Editor-Side Configuration(客户端配置)

改变服务端api和改变客户端(CKEditor)api 二者选其一,参考
s. You can do it using the [CKEDITOR.editor.fileUploadRequest](http://docs.ckeditor.com/#!/api/CKEDITOR.editor-event-fileUploadRequest) and [CKEDITOR.editor.fileUploadResponse](http://docs.ckeditor.com/#!/api/CKEDITOR.editor-event-fileUploadResponse) events.


##[File Manager Integration](http://docs.ckeditor.com/#!/guide/dev_file_browse_upload-section-using-ckfinder)

![](http://docs.ckeditor.com/guides/dev_file_browse_upload/image_dialog_browser_upload.png)

要想显示图文混排的网页,图片要么是互联网地址,要么存在本地服务器,在文章中引用此地址,

这就需要文件上传,CK就有此功能,

### Basic Configuration


如果要使用  integrate CKEditor ,你需要进行下面的配置   

The [config.filebrowserBrowseUrl](http://docs.ckeditor.com/#!/api/CKEDITOR.config-cfg-filebrowserBrowseUrl) setting contains the location of an external file browser that should be launched when the **Browse Server** button is pressed.点击浏览服务器按钮,访问这个链接地址

The [config.filebrowserUploadUrl](http://docs.ckeditor.com/#!/api/CKEDITOR.config-cfg-filebrowserUploadUrl) setting contains the location of a script that handles file uploads. If set, the **Upload** tab will appear in some dialog windows — the ones where such functionality is available, i.e. Link, Image and Flash Properties. 点击上传,就上传此文件(把本地文件上传到服务端)
![](imgs/ck1.jpg)


用下面的配置就能简单创建一个 file manager

```js
CKEDITOR.replace( 'editor1', {
    filebrowserBrowseUrl: '/browser/browse.php',
    filebrowserUploadUrl: '/uploader/upload.php'
});
```

例子:

```html
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex, nofollow">
    <title>Uploading Dropped and Pasted Images</title>
    <script src="http://cdn.ckeditor.com/4.6.2/standard-all/ckeditor.js"></script>
</head>

<body>

    <textarea cols="10" id="editor2" name="editor2" rows="10" >&lt;p&gt;This is some &lt;strong&gt;sample text&lt;/strong&gt;. You are using &lt;a href="http://ckeditor.com/"&gt;CKEditor&lt;/a&gt;.&lt;/p&gt;
    </textarea>

    <script>
        CKEDITOR.replace( 'editor2', {
            extraPlugins: 'uploadimage,image2',
            height: 300,

            // Upload images to a CKFinder connector (note that the response type is set to JSON).
            uploadUrl: '/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Files&responseType=json',

            // Configure your file manager integration. This example uses CKFinder 3 for PHP.
            filebrowserBrowseUrl: '/ckfinder/ckfinder.html',
            filebrowserImageBrowseUrl: '/ckfinder/ckfinder.html?type=Images',
            filebrowserUploadUrl: '/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Files',
            filebrowserImageUploadUrl: '/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Images',

            // The following options are not necessary and are used here for presentation purposes only.
            // They configure the Styles drop-down list and widgets to use classes.

            stylesSet: [
                { name: 'Narrow image', type: 'widget', widget: 'image', attributes: { 'class': 'image-narrow' } },
                { name: 'Wide image', type: 'widget', widget: 'image', attributes: { 'class': 'image-wide' } }
            ],

            // Load the default contents.css file plus customizations for this sample.
            contentsCss: [ CKEDITOR.basePath + 'contents.css', 'http://sdk.ckeditor.com/samples/assets/css/widgetstyles.css' ],

            // Configure the Enhanced Image plugin to use classes instead of styles and to disable the
            // resizer (because image size is controlled by widget styles or the image takes maximum
            // 100% of the editor width).
            image2_alignClasses: [ 'image-align-left', 'image-align-center', 'image-align-right' ],
            image2_disableResizer: true
        } );
    </script>
</body>

</html>
```