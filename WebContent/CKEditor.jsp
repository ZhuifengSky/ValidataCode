<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="static/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
	 window.onload = function() {
		var editor2 = CKEDITOR.replace( 'editor2', {
		    language: 'fr',
		    uiColor: '#9AB8F3'
		});
		
	 }
	 function onSub(){
		 var data = CKEDITOR.instances.editor1.getData();
		 alert(data);
	 }
	 

</script>
<title>Insert title here</title>
</head>
<body>
	<form action="#" method="post" onsubmit="onSub()">
            <textarea name="editor1" id="editor1" rows="5" cols="40">
                This is my textarea to be replaced with CKEditor.
            </textarea>
            <hr>
            <textarea name="editor2" id="editor2" rows="5" cols="30">
                This is my textarea2 to be replaced with CKEditor.
            </textarea>
            <input type="submit" value="提交">
    </form>
    <script type="text/javascript">
		var editor1 =  CKEDITOR.replace( 'editor1', {
		    language: 'fr',
		    uiColor: '#AADC6E'
		});
		// The "change" event is fired whenever a change is made in the editor.
		// 实时统计编辑器内容的大小
		editor1.on( 'change', function( evt ) {
		    // getData() returns CKEditor's HTML content.
		    console.log( 'Total bytes: ' + evt.editor.getData().length);
		});
    </script>
</body>
</html>