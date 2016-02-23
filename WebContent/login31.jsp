<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	function changeImg() {
		var imgSrc = $("#imgObj");
		var src = imgSrc.attr("src");
		imgSrc.attr("src", chgUrl(src));
	}
	//时间戳
	//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
	function chgUrl(url) {
		var timestamp = (new Date()).valueOf();
		url = url.substring(0, 17);
		if ((url.indexOf("&") >= 0)) {
			url = url + "×tamp=" + timestamp;
		} else {
			url = url + "?timestamp=" + timestamp;
		}
		return url;
	}

	function isRightCode() {
		var code = $("#veryCode").val();
		alert(code);
		code = "c=" + code;
		$.ajax({
			type : "POST",
			url : "ScaptchaValiServlet",
			data : code,
			success : callback
		});
	}

	function callback(data) {
		$("#info").html(data);
	}
</script>
</head>
<body>
	 <input id="veryCode" name="veryCode" type="text"/>  
     <img id="imgObj" alt="valiCode" src="sCaptcha.jpg"/>  
	 <a href="javascript:changeImg()">换一张</a>  
	 <input type="button" value="验证" onclick="isRightCode()"/>  
	 <div id="info"></div>  
	
</body>
</html>