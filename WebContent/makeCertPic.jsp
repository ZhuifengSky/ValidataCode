<%@ page language="java" contentType="image/jpeg" pageEncoding="UTF-8"%>
<jsp:useBean id="image" scope="page" class="com.util.makeCertPic" />
<%	
    String str=image.getCertPic(0,0,response.getOutputStream());
	session.setAttribute("certCode", str); 
	out.clear();
 	out = pageContext.pushBody();
%>
