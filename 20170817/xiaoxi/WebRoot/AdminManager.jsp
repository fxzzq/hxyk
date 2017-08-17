<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,java.sql.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <title>My</title>
         <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
       %>
     <script src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  </head>
  <body>
 <br> <br> <br>
   <p align="center" style="background:blue"><font color="#ffffff">管理员管理</font> </p>
     <table class="table table-bordered">
     <thead>
  	<tr>
		  <th> <p align="center" >管理员账号 </p></th>
		   <th> <p align="center" >管理员密码</p></th>
		   <th> <p align="center" >操作</p></th>
	  </tr>
	 </thead>   
	 <tbody>
	 
	 <%
	String driverClass = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://118.89.38.92:3306/xiaoxi";
	String username = "xzq";
	String password = "123456";
		/* 注册驱动 */
	Class.forName(driverClass);
		/* 获得连接 */
	Connection conn = DriverManager.getConnection(url, username,
				password);
		/* 申请一个statement */
		Statement st = conn.createStatement();
			/*  执行SQL语句 */
	String querySQL = "select * from administrators ";
	System.out.println(querySQL);
		st.executeQuery(querySQL);
		/* 处理结果集 */
	ResultSet rs = st.executeQuery("select * from administrators");

	String passname;//传到deleteuser.jsp
		int id;
		String name;
	String pwd;
	//将查询结果集中的记录输出到页面上  
		while (rs.next()) {
			//从当前记录中读取各字段的值    
			//id = rs.getInt(1);
			name = rs.getString(2).trim(); //.trim()去除空格
			pwd = rs.getString(3).trim();

				out.println("<tr>");
					out.println("<td align='center' id='name'>");
				out.println(name);
					out.println("</td>");
				out.println("<td align='center'>");
					out.println(pwd);
					out.println("</td>");
			
			out.println("<td align='center'><a href='login.jsp'>修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='deleteuser.jsp?passname=" + name+ "' onclick='confirm_delete()'>删除</a></td>");
								
				out.println("</tr>");
							}

				/*   关闭jbbc对象    */
				rs.close();
				st.close();
			conn.close();
	%>
	 
	 
	 </tbody>
  </table>
  
  
  
  
  
  <br>
  <p align="center" style="background:blue"><font color="#ffffff">管理员添加</font> </p>
  	<form action="doAddAdmins.jsp"  method="post">
       <table class="table table-bordered">
     <thead>
  	<tr>
		  <th> <p align="center" >管理员账号:
		  <input type="text"  name="username" autocomplete="off" id="username">
		  </p></th>
		   <th> <p align="center" >管理员密码:
		   <input type="password"  name="password" autocomplete="off" id="password">
		   </p></th>
		   <th> <p align="center" >
		   <button type="submit" class="btn btn-primary btn-sm" onclick="addsuccess()">添加</button>
		   </p></th>
	  </tr>
	 </thead>   
	 <tbody>
	  
	 </tbody>
  </table>
  </form>
  
  
  
  
  <script type="text/javascript">
     function addsuccess(){
     var user=document.getElementById("username").value;
     var pwd=document.getElementById("password").value;
    //  getElementById  没有s

     if(user!=""&&pwd!=""){
      
        alert("添加成功!");
      }
      else{
        alert("用户名或密码不能为空!");
      }
    
     } 
     
    function  confirm_delete(){
    //var name=document.getElementById("name").value;
      // alert(name);
    //   confirm("你确认要删除这个管理员吗?\n此操作将不可恢复！！");
    alert("删除成功！\n此操作将不可恢复！！");
    }
  </script>
  </body>
</html>
