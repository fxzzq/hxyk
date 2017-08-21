package com.xige.shopping.pageservlet;
import com.xige.shopping.util.CaptchaUtil;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/captcha.do")
public class CaptachServelt extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/png");
		HttpSession session=req.getSession();
		OutputStream out=resp.getOutputStream();
		String code=CaptchaUtil.generateCaptcha(out);
		session.setAttribute("captchaCode", code);
		//放入验证码到session
	
		out.close();
	}
}
