package com.xige.shopping.pageservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xige.shopping.entities.OderInfo;
import com.xige.shopping.service.OderInfoService;
import com.xige.shopping.service.OderInfoServiceImpl;
@WebServlet("/list")

public class OderListServlet extends HttpServlet {
    private List<OderInfo> oders;
    private OderInfoService oderinfoservice;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String p = req.getParameter("page");
    	oderinfoservice = new OderInfoServiceImpl();
    	try {
			oders = oderinfoservice.getOders();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        int page;
        try {
        	
            //��ǰҳ��
            page = Integer.valueOf(p);
        } catch (NumberFormatException e) {
            page = 1;
        }
        //�û�����
        int totalUsers = oders.size();
        //ÿҳ�û���
        int usersPerPage = 5;
        //��ҳ��
        int totalPages = totalUsers % usersPerPage == 0 ? totalUsers / usersPerPage : totalUsers / usersPerPage + 1;
        //��ҳ��ʼ�û����
        int beginIndex = (page - 1) * usersPerPage;
        //��ҳĩβ�û���ŵ���һ��
        int endIndex = beginIndex + usersPerPage;
        if (endIndex > totalUsers)
            endIndex = totalUsers;
        req.setAttribute("totalUsers", totalUsers);
        req.setAttribute("usersPerPage", usersPerPage);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("beginIndex", beginIndex);
        req.setAttribute("endIndex", endIndex);
        req.setAttribute("page", page);
        //��Ҫ
        req.setAttribute("users", oders);
        
        System.out.println("oderlistservlet��ɣ�");
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }

 
}