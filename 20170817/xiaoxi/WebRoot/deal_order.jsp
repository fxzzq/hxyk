<%@ page language="java" import="java.util.*,java.sql.*" 
contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<!-- 解决插入数据库中文论码 -->
<%request.setCharacterEncoding("utf-8");%> 
<!DOCTYPE HTML>
<html>
  <head>   
    <title>处理订单</title>
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
    
    //订单信息表
	String productname=request.getParameter("suk");
    String price=request.getParameter("jg");
    String liuyan=request.getParameter("guest");
    //获取下单时间
    java.util.Date date=new java.util.Date();
    java.text.SimpleDateFormat format=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String odertime=format.format(date);
    
    
    //买家信息
    String name=request.getParameter("name");
    String mob=request.getParameter("mob");
    String pay_method=request.getParameter("zhifubao");
    //地址       省份+市 +区+详细地址
    String province=request.getParameter("bdprovince");
    String bdcity=request.getParameter("bdcity");
    String bdarea=request.getParameter("bdarea");
    String address=request.getParameter("address");
    //拼接
    String addressAll=province+bdcity+bdarea+address;
    
    
    
    Statement stmt=conn.createStatement();
    String insertSQL = "INSERT INTO oderinfo(productname,price,remarks,odertime,oderstate,pay_method,username,tel,address) Values ('"+productname+"','"+price+"','"+liuyan+"','"+odertime+"','待处理','"+pay_method+"','"+name+"','"+mob+"','"+addressAll+"')";
   // String insertSQL2 = "INSERT INTO userinfo(username,tel,pay_method,address) Values ('"+name+"','"+mob+"','"+pay_method+"','"+addressAll+"')";
  
    System.out.println(insertSQL);
 //   System.out.println(insertSQL2);
    
    st.executeUpdate(insertSQL);
  //  st.executeUpdate(insertSQL2);
	
	//返回 购买成功
    response.setHeader("refresh", "0;url=buysuccess.jsp");
	
	
	
	stmt.close();
	conn.close();
    %>
  </body>
</html>
