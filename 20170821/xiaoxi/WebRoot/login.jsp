<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
 pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>登录页面</title>
       <style type="text/css">
        	.img{
        	float: left;
        	}
        	.code{
        	float: left;
        	
        	}
        	a{
        	text-decoration:none;
        	}
        </style>
        
     <link rel="shortcut icon" href="images/icon.png">
      <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
       %>
     <script src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
     <script type="text/javascript" language="javascript" src="${APP_PATH}/static/js/login.js" charset="gb2312"></script>
  </head>
  <body>
  <br> <br> <br> <br> <br> <br> <br> <br> <br>
 <p><strong><b>	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;
 &nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;
 	&nbsp;<font size="12">网站后台管理系统</font></b></strong></p><br>
<form class="form-horizontal" action="login.do" method="post">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-3">
      <input type="text" class="form-control" name="username" id="userName" placeholder="username" autocomplete="off" >
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-3">
      <input type="password" class="form-control" name="password" id="pwd"  placeholder="password" autocomplete="off" >
    </div>
  </div>
  
  <div class="form-group">
  <label class="col-sm-2 control-label">验证码</label>
  <div class="col-sm-3">
  <input name= "code" id="code" class="form-control"  type="text"  placeholder="Captcha" autocomplete="off">
    </div>
  </div>
   
  <div class="form-group">
  <label class="col-sm-2 control-label"></label>
  <div class="col-sm-3">
  <img onclick="switchCaptchaImg(this)" src="captcha.do" style="height: 50px; width: 200px" id="img">
    <a href="#" onclick="changeVerifyCode(this)" >看不清？换一张</a>
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label >
                      <!--  name和id都改成一样 -->
          <input type="checkbox" name="remFlag" id="remFlag" onclick="remember();" > 记住密码
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default" id="loginform_submit">登录</button>
    </div>
  </div>
</form>
<script type="text/javascript">
$(document).ready(function(){
        //记住密码功能
        var str = getCookie("loginInfo");
        str = str.substring(1,str.length-1);
        var username = str.split(",")[0];
        var password = str.split(",")[1];
        //自动填充用户名和密码
        $("#userName").val(username);
        $("#pwd").val(password);
});

//获取cookie
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
    }
    return "";
}

//记住密码功能
function remember(){
    var remFlag = $("input[type='checkbox']").is(':checked');
    if(remFlag==true){ //如果选中设置remFlag为1
        //cookie存用户名和密码,回显的是真实的用户名和密码,存在安全问题.
        var conFlag = confirm("记录密码功能不宜在公共场所(如网吧等)使用,以防密码泄露.您确定要使用此功能吗?");
        if(conFlag){ //确认标志
            $("#remFlag").val("1");
            //alert(remFlag);
        }else{
            $("input[type='checkbox']").removeAttr('checked');
            $("#remFlag").val("");
        }
    }else{ //如果没选中设置remFlag为""
        $("#remFlag").val("");
    }
}

</script>
<script>
		var switchCaptchaImg=function(img){
			if(!img["data-src"]){
				img["data-src"]=img.src;
			}
			img.src=img["data-src"]+"?"+Math.random();
		};
		
function changeVerifyCode(){  
    document.getElementById("img").src="captcha.do?t="+Math.random();  
      
}		
		
		
		
</script>
  </body>
</html>
