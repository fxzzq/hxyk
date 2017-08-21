<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 解决插入数据库中文论码 -->
 <% request.setCharacterEncoding("UTF-8");%>
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
  <style type="text/css">
  #div{
  text-align:left;
  margin:0 auto;
  background:#4F94CD;
  height:25px
  }
  #div1{
  border:1px solid #fff
  
  }
  #div2 button{
     align:center;
  }
  
  </style>
  </head>
  <body>
 <br>  <br> 
 <%
 //从session中获取订单id 
// String id=(String)request.getSession().getAttribute("id");
  %>
  <!-- 设置requestScope的oderdetail 对象   -->
   <c:set var="curtOderdetail" value="${requestScope.oderdetail}"/>
   
 <p align="center" style="background:blue"><font  size="4" color="#ffffff">订单详情</font> </p> 
 <form action="AddStateInfo.do" method="post">
 <div class="container-fluid">
 <!--  遍历整个id=? 的信息-->
 <c:forEach var="oderdetail" items="${curtOderdetail}">
 <!--用户信息  -->
 <div class="row" >
    <div class="col-md-12"  id="div">
    <font color="#ffffff">用户信息:</font>
    </div>
    <div class="row">
      <div class="col-md-4" id="div1">&nbsp;&nbsp;&nbsp;姓名:&nbsp;&nbsp;&nbsp;${oderdetail.username} </div>
      <div class="col-md-4" id="div1">&nbsp;&nbsp;&nbsp;手机:&nbsp;&nbsp;&nbsp;${oderdetail.tel} </div>
      <div class="col-md-4" id="div1">&nbsp;&nbsp;&nbsp;付款方式:&nbsp;&nbsp;&nbsp;${oderdetail.pay_method}</div>
    </div>
    <div class="row" >
    <div class="col-md-12"  id="div1">&nbsp;&nbsp;&nbsp;收货地址:&nbsp;&nbsp;&nbsp;${oderdetail.address}</div>
    </div>
</div>
<!--订单信息  -->
 <div class="row" >
    <div class="col-md-12"  id="div">
    <font color="#ffffff">订单信息:</font>
    </div>
    <div class="row">
      <div class="col-md-12" id="div1">&nbsp;&nbsp;&nbsp;订购商品:&nbsp;&nbsp;&nbsp;${oderdetail.productname} </div>
    </div>
    <div class="row" >
    <div class="col-md-12"  id="div1">&nbsp;&nbsp;&nbsp;价格:&nbsp;&nbsp;&nbsp;${oderdetail.price}元</div>
    </div>
    <div class="row" >
    <div class="col-md-12"  id="div1">&nbsp;&nbsp;&nbsp;备注说明:&nbsp;&nbsp;&nbsp;${oderdetail.remarks}</div>
    </div>
</div>
<!-- 状态信息: -->
 <div class="row" >
    <div class="col-md-12"  id="div">
    <font color="#ffffff">状态信息:</font>
    </div>
    <div class="row">
      <div class="col-md-12" id="div1">&nbsp;&nbsp;&nbsp;下单的时间:&nbsp;&nbsp;&nbsp;${oderdetail.odertime} </div>
    </div>
    <div class="row" >
    <div class="col-md-12"  id="div1">&nbsp;&nbsp;&nbsp;快递公司是:
    <input type="text" name="expresscompany" id="expresscompany" autocomplete="off" value="${oderdetail.expresscompany}"/>
    </div>
    </div>
    <div class="row" >
    <div class="col-md-12"  id="div1">&nbsp;&nbsp;&nbsp;快递运单号:
    <input type="text" name="expressID"  id="expressID" autocomplete="off" value="${oderdetail.expressID}" />
    </div>
    </div>
    <div class="row" >
    <div class="col-md-12"  id="div1">&nbsp;&nbsp;&nbsp;订单的状态:
    <%
    ArrayList<Object> op=new ArrayList<Object>();
    op.add("待发货");
    op.add("已发货");
    op.add("交易成功");
    op.add("交易关闭");
      
     %>
    <select  name=selop>
    <option>${oderdetail.oderstate}</option>
     <%
		for (int i = 0; i <op.size(); i++) {  
			out.print("<option>" + op.get(i) + "</option>");  
                    }  
      %>
    </select>
    </div>
    </div>
    <div class="row" align="center">
    <div class="col-md-12"  id="div2">
               <button type="submit" onclick="return alter(this.form);" class="btn btn-primary">提交</button>
               <button type="reset"class="btn btn-success">重置</button>
               <a href="list.jsp"><button type="button"class="btn btn-warning">返回</button></a>
                </div>
               </div>
               </div>
 </c:forEach>

</div>
  </form>
  <script type="text/javascript">
  function alter(form){
 			 if(form.expresscompany.value=='') {
                alert("快递公司为空!");
                form.expresscompany.focus();
                return false;
         		  }
  	          if(form.expressID.value=='') {
                alert("单号为空!");
                form.expressID.focus();
                return false;
         		  }
   		
 		        alert("状态信息修改成功！");
  		        return true;
      
  }
  
  </script>
  
  </body>
</html>
