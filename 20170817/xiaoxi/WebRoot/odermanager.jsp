<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,java.sql.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--  subList 声明 -->
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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
  				<!-- 时间javaSript -->
 <script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js">
 </script>
  </head>
  <body>
  <br> <br>

<p align="center" style="background:blue"><font color="#ffffff" size="5">订单管理</font> </p>
<div align="right">
<p >日期查询: 
<input name="createdatetimeStart" style="width: 190px;" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
-- 
<input name="createdatetimeStart" style="width: 190px;" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
<select>
  <option value="oderstate">订单状态</option>
  <option value="stay_deliver">待发货</option>
  <option value="already_deliver">已发货</option>
  <option value="transaction_success">交易成功</option>
   <option value="transaction_close">交易关闭</option>
</select>
<button  type="button" class="btn btn-primary">搜索</button>
</p>	
</div>         
 <div class="row" >
        <div class="col-md-12">
     
              

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
	String querySQL = "select o.productname,u.username,u.tel,u.address,o.oderstate,o.odertime from  userinfo as u,oderinfo as o where u.id=o.oderid";
	String querySQL1="select count(*) from userinfo ";
	System.out.println(querySQL);
	//	st.executeQuery(querySQL);
	
		/* 处理结果集 */
	ResultSet rs1=st.executeQuery(querySQL1);
	   //totalRecord必须初始化
	  int  totalRecord=0;
		while (rs1.next()) {
	    totalRecord=rs1.getInt(1);
	    System.out.println("总记录数:"+totalRecord);
	}
	
	    System.out.println("总记录数外:"+totalRecord);
	ResultSet rs = st.executeQuery(querySQL);
	
		String productname;
		String name;
	    String tel;
	    String address;
	    String oderstate;
	    String odertime;
	//将查询结果集中的记录输出到页面上  
		while (rs.next()) {
			//从当前记录中读取各字段的值    
		
			productname = rs.getString(1).trim(); //.trim()去除空格
			name = rs.getString(2).trim();
            tel = rs.getString(3).trim();
            address = rs.getString(4).trim();
            oderstate=rs.getString(5).trim();
            odertime = rs.getString(6).trim();
            
           //把订单数据放入list中 
           List<String> list=new ArrayList<String>(); 
                   list.add(productname);
                   list.add(name);
                   list.add(tel);
                   list.add(address);
                   list.add(oderstate);
                   list.add(odertime); 
                System.out.println("list:"+list);
                
            		
		String p = request.getParameter("page");
      int curpage;
        try {
            //当前页数
            curpage = Integer.valueOf(p);
        } catch (NumberFormatException e) {
            curpage = 1;
        }
        //用户总数
         
        //每页用户数
        int usersPerPage =5;
        //总页数
     
      //  System.out.println(totalRecord+usersPerPage);
         int totalPages=(totalRecord % usersPerPage == 0 ? totalRecord / usersPerPage : totalRecord / usersPerPage + 1);
        //本页起始用户序号
      
      int    beginIndex  = (curpage - 1) * usersPerPage;
        //本页末尾用户序号的下一个
        int endIndex = beginIndex + usersPerPage;
        if (endIndex > totalRecord)
            endIndex = totalRecord;
        request.setAttribute("totalUsers", totalRecord);
        request.setAttribute("usersPerPage", usersPerPage);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("beginIndex", beginIndex);
        request.setAttribute("endIndex", endIndex);
        request.setAttribute("page", curpage);
        
        request.setAttribute("list", list);
      //  request.getRequestDispatcher("odermanager.jsp").forward(request, response);  
               
              
                  
                  
                  
                  
                  
                  
                  
                      
       /*    out.println("<tr>");
               out.println("<td>");
                    out.println("<input type='checkbox' id='check_all'/>");
           	        out.println("</td>");
			   out.println("<td>");
				    out.println(productname);
					out.println("</td>");
				out.println("<td>");
					out.println(name);
					out.println("</td>");
			    out.println("<td>");
					out.println(tel);
					out.println("</td>");
				out.println("<td>");
					out.println(address);
					out.println("</td>");
				
		  //订单状态处理
                if(oderstate.equals("待处理")){
                	out.println("<td>");
                	out.println("<font color='red'>");
					out.println(oderstate);
					out.println("</font>");
					out.println("</td>");
                }
                else{
                	out.println("<td>");
					out.println(oderstate);
					out.println("</td>");
                }
					
				out.println("<td>");
					out.println(odertime);
					out.println("</td>");
				out.println("<td>");
					out.println("<a href=''>");
					out.println("详情");
					out.println("</a>");
					out.println("</td>");
		out.println("</tr>"); */
		
              
                 
		
							}

				/*   关闭jbbc对象    */
				rs.close();
				st.close();
			conn.close();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	%>
	
	
<div class="container">

    <c:set var="totalUsers" value="${requestScope.totalUsers}"/>
    <c:set var="usersPerPage" value="${requestScope.usersPerPage}"/>
    <c:set var="totalPages" value="${requestScope.totalPages}"/>
    <c:set var="beginIndex" value="${requestScope.beginIndex}"/>
    <c:set var="endIndex" value="${requestScope.endIndex}"/>
    <c:set var="page" value="${requestScope.page}"/>
     <c:set var="curpage" value="${requestScope.list}"/> 
    <!--  .subList(beginIndex,endIndex) -->
    <p>用户总数:${totalUsers}</p>
    <p>每页用户数:${usersPerPage}</p>
    <p>总页数:${totalPages}</p>
    <p>当前页:${page}</p>
    <p>当前页:${curpage}</p>
         

    <table class="table table-hover table-responsive table-striped table-bordered" id="emps_table">
        <thead>
				<tr>
                    <td>选中</td>
                    <td align="center">产品</td>
                    <td>姓名</td>
                    <td>手机</td>
                    <td align="center">收货人地址</td>
                    <td>订单状态</td>
                     <td align="center">下单时间</td>
                      <td>编辑</td>
                </tr>
        </thead>
        <tbody>
     <c:forEach  items="${curpage}" var="list">
            <tr>
                <td>${list}</td>
            </tr>
        </c:forEach>
        </tbody> 
                 
    </table>

    <hr>

    <div class="text-center">
        <nav>
            <ul class="pagination">
                <li><a href="<c:url value="/odermanager.jsp?page=1"/>">首页</a></li>
                <li><a href="<c:url value="/odermanager.jsp?page=${page-1>1?page-1:1}"/>">&laquo;</a></li>

                <c:forEach begin="1" end="${totalPages}" varStatus="loop">
                    <c:set var="active" value="${loop.index==page?'active':''}"/>
                    <li class="${active}"><a
                            href="<c:url value="/odermanager.jsp?page=${loop.index}"/>">${loop.index}</a>
                    </li>
                </c:forEach>
                <li>
                    <a href="<c:url value="/odermanager.jsp?page=${page+1<totalPages?page+1:totalPages}"/>">&raquo;</a>
                </li>
                <li><a href="<c:url value="/odermanager.jsp?page=${totalPages}"/>">尾页</a></li>
            </ul>
        </nav>
    </div>


</div>
	


              
     
        </div>
    </div>
  </body>
</html>
