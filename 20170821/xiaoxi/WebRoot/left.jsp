<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>后台管理</title>
    <link rel="shortcut icon" href="images/icon.png">
    <!--不打开新窗口的方法  -->
<script type="text/javascript">
   function subform(){
   if(confirm('确定退出奚哥网站后台系统？')){
  
   // window.name = "curWindow";
   
   window.close();//关闭窗口
    return true;
   }else{
    var form = document.getElementById('myForm');
        form.href="indexadmin.jsp";
     return false;
   }
  
   }
      
      
</script>
  </head>
  <body>
  <br><br><br><br>
    系统管理中心<br> <br><br>
  <a href="${pageContext.request.contextPath }/logout.do"  onClick="subform()" style="text-decoration: none" target="curWindow" id="myForm"  >
      ※ |安全退出</a><br><br>
  <a href="ManagerIndex.jsp"  style="text-decoration: none" target="view_frame">※ |管理员首页</a><br><br>
  <a href="AdminManager.jsp"  style="text-decoration: none" target="view_frame">※ |管理员管理</a><br><br>
  <a href="list.jsp"  style="text-decoration: none" target="view_frame">※ |订单管理</a>

  </body>
</html>
