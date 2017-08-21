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
@WebServlet("/OderDetailsServlet.do")
public class OderDetailsServlet extends HttpServlet {
    private List<OderInfo> oderdetail;
    private OderInfoService oderinfoservice;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
     	oderinfoservice = new OderInfoServiceImpl();
     	
     	
     	String id=req.getParameter("id");
     	// 把值存入session传到oderDetails.jsp
     	HttpSession session=req.getSession();//获得一个session对象
     	session.setAttribute("id",id);
     	
 
     	
       
        	System.out.println("oderDetailsServlet:"+id);
        	try {
    			
        		oderdetail = oderinfoservice.getOderByid(id);
        		
        		 req.setAttribute("oderdetail", oderdetail);
        	     req.getRequestDispatcher("oderDetails.jsp").forward(req, resp);
    			
    		} catch (Exception e) {
    			
    			e.printStackTrace();
    		}
        	
        
      
     	
     
    }

  
}