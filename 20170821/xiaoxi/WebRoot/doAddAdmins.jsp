<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<!-- 解决插入数据库中文论码 -->
<%request.setCharacterEncoding("utf-8");%>  
<html>
  <head> 
    <title>添加管理员</title>
  </head>
  <body>
   <%
  String driverClass="com.mysql.jdbc.Driver";
    String url="jdbc:mysql://118.89.38.92:3306/xiaoxi?useUnicode=true&characterEncoding=UTF-8";
    String username="xzq";
    String password="123456";
    Class.forName(driverClass);
    Connection  conn=DriverManager.getConnection(url,username,password);
    Statement st = conn.createStatement();
	String uname=request.getParameter("username");
    String upwd=request.getParameter("password");
    if(uname!=""&&upwd!=""){
        Statement stmt=conn.createStatement();
    String insertSQL = "INSERT INTO administrators(managername,managerpwd) Values ('"+uname+"', '"+upwd+"' )";
    System.out.println(insertSQL);
    st.executeUpdate(insertSQL);
	ResultSet rs = stmt.executeQuery("select * from administrators");
	
	rs.close();
	stmt.close();
	conn.close();
    }
    else{
    
    }
  
	//out.println("<center><b><stong><big><h1>");
	//out.println("管理员成功自动跳到管理员管理页面");
	//out.println("</h1></big></strong></b></center>");
	response.setHeader("refresh", "0;url=AdminManager.jsp");
	    
	
%>
  </body>
</html>
