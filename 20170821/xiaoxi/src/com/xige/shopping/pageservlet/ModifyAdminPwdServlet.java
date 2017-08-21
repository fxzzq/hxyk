package com.xige.shopping.pageservlet;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xige.shopping.service.OderInfoService;
import com.xige.shopping.service.OderInfoServiceImpl;
@WebServlet("/modifyadminpwd.do")
public class ModifyAdminPwdServlet extends HttpServlet {
	private OderInfoService oderinfoservice;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String Newupwd=req.getParameter("upwd");
	    String reupwd=req.getParameter("reupwd");
	    //��session�н���Ҫ�޸ĵĹ���Ա����    ����������޸�����
	    String adminname=(String)req.getSession().getAttribute("adminname");
	    
		oderinfoservice = new OderInfoServiceImpl();
		try {
		int result=	oderinfoservice.ModifyAdminPwd( Newupwd,adminname);
     
		  System.out.println("�޸Ĺ���Ա"+adminname+"����ɹ���Ӱ������ i = " +result);
		  resp.sendRedirect(req.getContextPath()+"/AdminManager.jsp");
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		 
}
}
