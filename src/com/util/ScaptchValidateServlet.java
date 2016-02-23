package com.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScaptchValidateServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		Cookie[] s = request.getCookies();
		System.out.println(s[0].getPath());
		System.out.println(s[0].getMaxAge());
		System.out.println(s[0].getName());
		String validateC = s[0].getValue();
		String veryCode = request.getParameter("c");
		PrintWriter out = response.getWriter();
		if(veryCode==null||"".equals(veryCode)){
			out.println("验证码为空");
		}else{
			if(validateC.equals(veryCode)){
				out.println("验证码正确");
			}else{
				out.println("验证码错误");
			}
		}
		out.flush();
		out.close();
	}

}

