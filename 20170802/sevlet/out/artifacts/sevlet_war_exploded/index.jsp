<%--
  Created by IntelliJ IDEA.
  User: xzq
  Date: 2017/8/2
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>jquery</title>
    <script src="jquery.js"></script>
    <script type="text/javascript">
      $(document).ready(function () {
          $("button").click(function () {
              var str=$("#test").val();
              if(str==''){
                  alert("error");
              }else{
                  alert($("#test").val());
              }

          });
      });
    </script>
  </head>
  <body>
  <p>姓名：<<input type="text" id="test" ></p>
  <button> 显示值</button>
  </body>
</html>
