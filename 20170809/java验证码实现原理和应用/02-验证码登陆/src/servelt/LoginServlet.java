package servelt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codeInput=req.getParameter("code");
		HttpSession session=req.getSession();
		String code=(String)session.getAttribute("captchaCode");
		System.out.println(code+"="+codeInput);
		if(code.equalsIgnoreCase(codeInput)){
			System.out.println("true");
		}else{
			resp.sendRedirect(req.getContextPath()+"/login.html");
		}
	}
}
