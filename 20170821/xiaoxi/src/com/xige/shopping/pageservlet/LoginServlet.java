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
		
		//��ס�û��������빦��(ע�⣺cookie����������ڰ�ȫ����)
        String remFlag = req.getParameter("remFlag");
        System.out.println("remFlag:"+remFlag);
        if("1".equals(remFlag)){ //"1"��ʾ�û���ѡ��ס����
            System.out.println("�û���ѡ��ס����!!");
            String loginInfo = uname+","+upwd;
            Cookie userCookie=new Cookie("loginInfo",loginInfo); 

            userCookie.setMaxAge(30*24*60*60);   //�����Ϊһ���� 30*24*60*60
            userCookie.setPath("/");
            resp.addCookie(userCookie); 
        }
		
		
		
		
		oderinfoservice = new OderInfoServiceImpl();
		try {
		String result=	oderinfoservice.checkadmin(uname, upwd);
		 if (result.equals("hasUserNameAndPasswordCorrect")) {
			     
	            System.out.println("�û������������ȷ");
	            //���û��� ����session
	            req.getSession().setAttribute("loginname", uname);
	            // �������session
	        	req.getSession().setAttribute("loginpwd", upwd);
	        	if(code.equalsIgnoreCase(codeInput)){

	                System.out.println("��֤����ȷ");
	                resp.sendRedirect(req.getContextPath()+"/indexadmin.jsp");

	            }else{

	                System.out.println("��֤�����");
	                resp.sendRedirect(req.getContextPath()+"/login.jsp");

	            }
	           

	        } 
		 else if (result.equals("hasUserNameButPasswordInCorrect")) {

	            System.out.println("�û�����ȷ,���벻��ȷ");
	            resp.sendRedirect(req.getContextPath()+"/login.jsp");
	        } 
		 else if (result.equals("hasNoUserName")) {

	            System.out.println("û�д��û�");
	            resp.sendRedirect(req.getContextPath()+"/login.jsp");
	        }

	        
		
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		 
}
}
