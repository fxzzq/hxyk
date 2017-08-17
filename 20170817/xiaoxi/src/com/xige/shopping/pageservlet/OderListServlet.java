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
        int page;
        try {
            //当前页数
            page = Integer.valueOf(p);
        } catch (NumberFormatException e) {
            page = 1;
        }
        //用户总数
        int totalUsers = oders.size();
        //每页用户数
        int usersPerPage = 5;
        //总页数
        int totalPages = totalUsers % usersPerPage == 0 ? totalUsers / usersPerPage : totalUsers / usersPerPage + 1;
        //本页起始用户序号
        int beginIndex = (page - 1) * usersPerPage;
        //本页末尾用户序号的下一个
        int endIndex = beginIndex + usersPerPage;
        if (endIndex > totalUsers)
            endIndex = totalUsers;
        req.setAttribute("totalUsers", totalUsers);
        req.setAttribute("usersPerPage", usersPerPage);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("beginIndex", beginIndex);
        req.setAttribute("endIndex", endIndex);
        req.setAttribute("page", page);
        req.setAttribute("users", oders);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
    	oderinfoservice = new OderInfoServiceImpl();
        try {
			oders = oderinfoservice.getOders();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }
}