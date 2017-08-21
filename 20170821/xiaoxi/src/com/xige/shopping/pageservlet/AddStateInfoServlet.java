package com.xige.shopping.pageservlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xige.shopping.entities.OderInfo;
import com.xige.shopping.service.OderInfoService;
import com.xige.shopping.service.OderInfoServiceImpl;

@WebServlet("/AddStateInfo.do")
public class AddStateInfoServlet extends HttpServlet {  
	private OderInfoService oderinfoservice;
	
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
    	 response.setHeader("content-type", "text/html;charset=UTF-8");  
    	 response.setCharacterEncoding("UTF-8");  
    	request.setCharacterEncoding("UTF-8"); 
    	     
            String expresscompany=request.getParameter("expresscompany");
            String expressID=request.getParameter("expressID");
            //取出Select里option的值
             String OderState = (String) request.getParameter("selop");  
             //开始提交
             System.out.println("-----提交状态信息中-----");
             
             System.out.println("servlet接收的状态信息:快递公司:"+expresscompany+"快递单号:"+expressID+"订单状态:"+OderState);
             
             //从 OderDetailsServlet的 session中获取订单id   
             String id=(String)request.getSession().getAttribute("id");
             //去除前后的空格
             String gid=id.trim();
             
             System.out.println("订单id从一个servlet里session设置，在另一个servlet里获取:"+gid);
             
               
             oderinfoservice = new OderInfoServiceImpl();
    		try {
    			
    			OderInfo oderinfo = this.oderinfoservice.getOderALLByid(gid);
    			  if(oderinfo!=null){
    		         int result=	oderinfoservice.AddExpressInfo( expresscompany,expressID,OderState,oderinfo);
         
    		          System.out.println("修改状态信息成功，影响行数 i = " +result);
    		         
    		          //实现servlet传值到另一个servlet 第1步
    		         request.setAttribute("id",gid);
    		        request.getRequestDispatcher("/OderDetailsServlet2.do").forward(request, response);
    		        
    		        //提交完成
    		        System.out.println("-----提交状态信息完成-----");
    		         
    		        
    			  }else{
    				  System.out.println("无此订单ID"+id+"的信息。");
    			  }
    		} catch (Exception e) {
    		
    			e.printStackTrace();
    		
    		}
       
         
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
        doGet(request, response);  
    }  
  
}  