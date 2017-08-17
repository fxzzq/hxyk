<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
  <table class="table table-bordered">
  	<tr>
		  <th> <p align="center" style="background:blue"><font color="#ffffff">欢迎光临奚哥网站后台</font> </p></th>
	  </tr>
	  <tr> 
	  	<td><p align="center">为了您的网站更加安全，退出时请点击左侧 [<a href="login.jsp">安全退出</a>]</p></td>
     </tr>
     <tr> 
	  	<td><p align="center">版权所有©请勿盗版 2016-2018</p></td>
     </tr>
  </table>
  </body>
</html>
