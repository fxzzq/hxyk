import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/dologin")
public class dologin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
        String uname=request.getParameter("username");
        String upwd=request.getParameter("password");
        if("xzq".equals(uname) && "123456".equals(upwd)){

            System.out.println("登录成功");
            request.getSession().setAttribute("sessionname",uname); //用Session保存用户名
            request.getSession().setAttribute("sessionpwd",upwd);   //用Session保存密码
            response.sendRedirect("loginsuccess.jsp");
        }else{

            System.out.println("登录失败");
            response.sendRedirect("loginerror.jsp");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
