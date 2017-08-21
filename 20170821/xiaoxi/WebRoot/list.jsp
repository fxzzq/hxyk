<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>

<!-- session控制 只有登录才能访问 -->
<%
	String login = (String) request.getSession().getAttribute(
			"loginname");
	if (login!=null) {
	} else {
		response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
    <title>简单分页订单管理</title>
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

 <div class="row">
 <div class="col-md-12">
<div class="container-fluid">

    <c:set var="totalUsers" value="${requestScope.totalUsers}"/>
    <c:set var="usersPerPage" value="${requestScope.usersPerPage}"/>
    <c:set var="totalPages" value="${requestScope.totalPages}"/>
    <c:set var="beginIndex" value="${requestScope.beginIndex}"/>
    <c:set var="endIndex" value="${requestScope.endIndex}"/>
    <c:set var="page" value="${requestScope.page}"/>
    <c:set var="currentPageUsers" value="${requestScope.users.subList(beginIndex,endIndex)}"/>

    <table class="table table-hover table-responsive table-striped table-bordered">
        <thead>
        <tr>
            <tr>
                    <td align="center">选中</td>
                    <td align="center">产品</td>
                    <td align="center">姓名</td>
                    <td align="center">手机</td>
                    <td align="center">收货人地址</td>
                    <td align="center">订单状态</td>
                    <td align="center">下单时间</td>
                    <td align="center">编辑</td>
                </tr>
      
        </thead>
        <tbody>
        <c:forEach var="user" items="${currentPageUsers}">
            <tr>
               <td align="center">
               <input type="checkbox" id="check_all"/>
               </td>
              
                <td align="center">${user.productname}</td>
                <td align="center">${user.username}</td>
                <td align="center">${user.tel}</td>
                <td align="center">${user.address}</td>
           
               <c:if test="${user.oderstate=='待处理'}">
               <td align="center"><font color="red">${user.oderstate}</font></td>
               </c:if>
               <c:if test="${user.oderstate=='待发货'}">
               <td align="center"><font color="yellow">${user.oderstate}</font></td>
               </c:if>
               <c:if test="${user.oderstate=='已发货'}">
               <td align="center"><font color="blue">${user.oderstate}</font></td>
               </c:if>
               <c:if test="${user.oderstate=='交易成功'}">
               <td align="center"><font color="green">${user.oderstate}</font></td>
               </c:if>
               <c:if test="${user.oderstate=='交易关闭'}">
               <td align="center"><font color="grey">${user.oderstate}</font></td>
               </c:if>
       
              
                 
                   
                               
              
                <td align="center">${user.odertime}</td>
                <td align="center"> 
               <a href=" <c:url value="OderDetailsServlet.do?id=+${user.id}+"/>">详情</a>
               </td>
              
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <hr>
     <%--显示分页信息--%>
    <div class="row" >
        <%--分页文字信息--%>
        <div class="col-md-6" id="page_info_area">
       <p><span>共${totalUsers}&nbsp;条记录</span>
          <span>当前页在第${page}&nbsp;页</span>
          <span>/共${totalPages}&nbsp;页</span>
          <span>页记录数${usersPerPage}&nbsp;条</span>
      </p>
        </div>
        <%--分页条信息--%>
        <div class="col-md-6" id="page_nav_area">
           <nav>
            <ul class="pagination">
                <li><a href="<c:url value="/list?page=1"/>">首页</a></li>
                <li><a href="<c:url value="/list?page=${page-1>1?page-1:1}"/>">&laquo;</a></li>

                <c:forEach begin="1" end="${totalPages}" varStatus="loop">
                    <c:set var="active" value="${loop.index==page?'active':''}"/>
                    <li class="${active}"><a href="<c:url value="/list?page=${loop.index}"/>">${loop.index}</a>
                    </li>
                </c:forEach>
                <li>
                    <a href="<c:url value="/list?page=${page+1<totalPages?page+1:totalPages}"/>">&raquo;</a>
                </li>
                <li><a href="<c:url value="/list?page=${totalPages}"/>">尾页</a></li>
            </ul>
        </nav>
        
        </div>

    </div>

</div>
  </div>
</div>
</body>
</html>