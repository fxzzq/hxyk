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
            //ȡ��Select��option��ֵ
             String OderState = (String) request.getParameter("selop");  
             //��ʼ�ύ
             System.out.println("-----�ύ״̬��Ϣ��-----");
             
             System.out.println("servlet���յ�״̬��Ϣ:��ݹ�˾:"+expresscompany+"��ݵ���:"+expressID+"����״̬:"+OderState);
             
             //�� OderDetailsServlet�� session�л�ȡ����id   
             String id=(String)request.getSession().getAttribute("id");
             //ȥ��ǰ��Ŀո�
             String gid=id.trim();
             
             System.out.println("����id��һ��servlet��session���ã�����һ��servlet���ȡ:"+gid);
             
               
             oderinfoservice = new OderInfoServiceImpl();
    		try {
    			
    			OderInfo oderinfo = this.oderinfoservice.getOderALLByid(gid);
    			  if(oderinfo!=null){
    		         int result=	oderinfoservice.AddExpressInfo( expresscompany,expressID,OderState,oderinfo);
         
    		          System.out.println("�޸�״̬��Ϣ�ɹ���Ӱ������ i = " +result);
    		         
    		          //ʵ��servlet��ֵ����һ��servlet ��1��
    		         request.setAttribute("id",gid);
    		        request.getRequestDispatcher("/OderDetailsServlet2.do").forward(request, response);
    		        
    		        //�ύ���
    		        System.out.println("-----�ύ״̬��Ϣ���-----");
    		         
    		        
    			  }else{
    				  System.out.println("�޴˶���ID"+id+"����Ϣ��");
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