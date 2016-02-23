package com.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.dao.IUserDao;
import com.main.model.User;




public class ImgFontByte extends HttpServlet {

	private static final long serialVersionUID = 4621074605453201722L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.sendRedirect("noright.jsp");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String userName = request.getParameter("userName");
		String userPSD = request.getParameter("password");
		String validateCode = request.getParameter("validateCode");
		
		User user = new User();
		
		if(userName != null && userName.length()>0 ){
			user.setUserName(userName);
		}
		if(userPSD != null && userPSD.length()>0 ){
			user.setPassword(userPSD);
		}

		String validateCodeInSession = (String) request.getSession()
				.getAttribute("valiCode");

		request.getSession().removeAttribute("valiCode");
		
		if (validateCodeInSession == null || validateCode == null
				|| !validateCode.equalsIgnoreCase(validateCodeInSession)) {
			request.getSession().setAttribute("InputError", "验证码错误");
			request.getSession().setAttribute("userName", userName);
			response.sendRedirect("login.jsp");
		} else {
			// 调用后台业务层的方法进行用户名和密码的校验！
			/*IUserDao ud = new UserDao();
			if (ud.validateUser(user)) {
				user = ud.find(user);
				request.getSession().setAttribute("user", user);
				response.sendRedirect("main.jsp");
			} else {
				request.getSession().setAttribute("InputError", "用户名或者密码错误");
				request.getSession().setAttribute("userName", userName);
				response.sendRedirect("login.jsp");
			}*/
		}
	}

}
