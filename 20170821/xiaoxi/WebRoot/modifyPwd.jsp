<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>    
    <title>My</title>
     <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
       %>
     <script src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  </head>
  <body>
 <br>  <br>  <br>  <br>  <br>  <br>  <br>
  <p align="center" style="background:blue"><font  size="5" color="#ffffff">管理员修改</font> </p>
  <form action="modifyadminpwd.do" method="post">
  <table class="table table-bordered">
	  <tr> 
	  	<td align="right">管理员帐号:</td>
	  	<td>
	  	<%
	  	//passname是从AdminManager.jsp传过来的。
		String passname = (String) request.getParameter("passname");
		//把值存入session传到ModifyAdminPwdServlet
		 session.setAttribute("adminname",passname);
		 //显示
		out.println(passname);
	  	 %>
	  	</td>
     </tr>
     <tr> 
	  	<td align="right">新密码:</td>
	  	<td>
	  	<input type="password" name="upwd"></input>
	  	</td>
     </tr>    
       <tr> 
	  	<td align="right">确认密码:</td>
	  	<td>
	  	<input type="password" name="reupwd"></input>
	  	</td>
     </tr>
       <tr> 
	  	<td></td>
	  	<td>
	  	<button class="btn btn-primary" type="submit">修改</button>
	  	<a href="AdminManager.jsp" ><button class="btn btn-primary" type="button">返回</button></a>
	  	</td>
     </tr>
  </table>
  </form>
  </body>
</html>
