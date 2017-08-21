<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- session控制 只有登录才能访问 -->
<%
	String login = (String) request.getSession().getAttribute(
			"loginname");
	if (login!=null) {
	} else {
		response.sendRedirect("login.jsp");
	}
%>

<!DOCTYPE HTML>
<html>
  <head>  
   <link rel="shortcut icon" href="images/icon.png">  
    <title>奚哥网站后台</title>
  </head> 

<frameset cols="180,*">

  <frame src="left.jsp"  style="background:#59b1de">
  <frame src="right.jsp"  style="background:#ffffff" name="view_frame">
</frameset>

</html>
