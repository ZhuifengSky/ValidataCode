package com.util;  
  
import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class SCaptchaServlet extends HttpServlet {  
    private static final long serialVersionUID = 1L;  
  
    @Override  
    protected void doGet(HttpServletRequest reqeust,  
            HttpServletResponse response) throws ServletException, IOException {  
        this.doPost(reqeust, response);  
    }  
  
    protected void doPost(HttpServletRequest reqeust,  
            HttpServletResponse response) throws ServletException, IOException {  
        // ������Ӧ�����͸�ʽΪͼƬ��ʽ  
        response.setContentType("image/jpeg");  
        // ��ֹͼ�񻺴档  
        response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        SCaptcha instance = new SCaptcha();  
        Cookie cookie = new Cookie("scaptcha", instance.getCode());
        Cookie cookie2 = new Cookie("dd", "ceshish");  
        cookie.setMaxAge(1800); 
        cookie2.setMaxAge(10);
        response.addCookie(cookie);
        response.addCookie(cookie2);  
        instance.write(response.getOutputStream());  
    }  
}  