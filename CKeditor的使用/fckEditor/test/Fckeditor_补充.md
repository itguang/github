# HTML Output Formatting(输出HTML格式)
---
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


