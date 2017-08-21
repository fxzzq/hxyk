package com.xige.shopping.pageservlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xige.shopping.entities.OderInfo;
import com.xige.shopping.service.OderInfoService;
import com.xige.shopping.service.OderInfoServiceImpl;
@WebServlet("/OderDetailsServlet2.do")
public class OderDetailsServlet2 extends HttpServlet {
    private List<OderInfo> oderdetail;
    private OderInfoService oderinfoservice;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
     	oderinfoservice = new OderInfoServiceImpl();
     
     	//ʵ��servlet��ֵ����һ��servlet ��2��  
     	//id id2��ʵ��һ��ֵ   ֻ�Ǵ�ֵ�ķ�ʽ��һ��
       String	id2=  req.getAttribute("id").toString();
       
      // ��ֵ����session����oderDetails.jsp
    	HttpSession session=req.getSession();//���һ��session����
    	session.setAttribute("id",id2);
     	
       
        	System.out.println("oderDetailsServlet---2:"+id2);
        	try {
    			
        		oderdetail = oderinfoservice.getOderByid(id2);
        		
        		 req.setAttribute("oderdetail", oderdetail);
        		// resp.sendRedirect(req.getContextPath()+"/oderDetails.jsp");  
        	     req.getRequestDispatcher("oderDetails.jsp").forward(req, resp);
    			
    		} catch (Exception e) {
    			
    			e.printStackTrace();
    		}
        	
        
      
     	
     
    }

  
}