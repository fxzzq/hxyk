<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>登录成功</title>
  </head>
  
  <body>
 登录成功<br>
 用户名: <%=request.getSession().getAttribute("sessionname")%><br>
 密码为：<%=request.getSession().getAttribute("sessionpwd")%>
  </body>
</html>
