package com.xige.shopping.pageservlet;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xige.shopping.service.OderInfoService;
import com.xige.shopping.service.OderInfoServiceImpl;
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private OderInfoService oderinfoservice;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname=req.getParameter("username");
	    String upwd=req.getParameter("password");
		String codeInput=req.getParameter("code");
	
		HttpSession session=req.getSession();
		String code=(String)session.getAttribute("captchaCode");
		System.out.println(code+"="+codeInput);
		
		//记住用户名、密码功能(注意：cookie存放密码会存在安全隐患)
        String remFlag = req.getParameter("remFlag");
        System.out.println("remFlag:"+remFlag);
        if("1".equals(remFlag)){ //"1"表示用户勾选记住密码
            System.out.println("用户勾选记住密码!!");
            String loginInfo = uname+","+upwd;
            Cookie userCookie=new Cookie("loginInfo",loginInfo); 

            userCookie.setMaxAge(30*24*60*60);   //存活期为一个月 30*24*60*60
            userCookie.setPath("/");
            resp.addCookie(userCookie); 
        }
		
		
		
		
		oderinfoservice = new OderInfoServiceImpl();
		try {
		String result=	oderinfoservice.checkadmin(uname, upwd);
		 if (result.equals("hasUserNameAndPasswordCorrect")) {
			     
	            System.out.println("用户名和密码均正确");
	            //把用户名 存入session
	            req.getSession().setAttribute("loginname", uname);
	            // 密码存入session
	        	req.getSession().setAttribute("loginpwd", upwd);
	        	if(code.equalsIgnoreCase(codeInput)){

	                System.out.println("验证码正确");
	                resp.sendRedirect(req.getContextPath()+"/indexadmin.jsp");

	            }else{

	                System.out.println("验证码错误");
	                resp.sendRedirect(req.getContextPath()+"/login.jsp");

	            }
	           

	        } 
		 else if (result.equals("hasUserNameButPasswordInCorrect")) {

	            System.out.println("用户名正确,密码不正确");
	            resp.sendRedirect(req.getContextPath()+"/login.jsp");
	        } 
		 else if (result.equals("hasNoUserName")) {

	            System.out.println("没有此用户");
	            resp.sendRedirect(req.getContextPath()+"/login.jsp");
	        }

	        
		
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		 
}
}
