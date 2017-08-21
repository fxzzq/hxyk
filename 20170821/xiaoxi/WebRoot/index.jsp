<%@ page language="java" import="java.util.*,java.sql.*" 
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 解决插入数据库中文论码 -->
<%request.setCharacterEncoding("UTF-8");%> 
  <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
  %>
<!DOCTYPE html>
<html>

<head>
<!--meta-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--css-->
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/order_style.css" />
<link rel="stylesheet" type="text/css" href="css/slider.css" >
<!--javascript-->
<script type="text/javascript" src="js/config.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/jquery.lazyload.js"></script>
<script type="text/javascript" src="js/jquery.slider.pack.js"></script>
<script type="text/javascript" src="js/jquery.easing.js"></script>
<script type="text/javascript">
$(function() {
	$('#cycle-prev, #cycle-next').css({opacity: '0'});
	$('.cycleslider-wrap').hover(function(){
		$('#cycle-prev',this).stop().animate({left: '-31', opacity: 

'1'},200,'easeOutCubic');
		$('#cycle-next',this).stop().animate({right: '-31', opacity: 

'1'},200,'easeOutCubic');	 
	}, function() {
		$('#cycle-prev',this).stop().animate({left: '-50', opacity: 

'0'},400,'easeInCubic');
		$('#cycle-next',this).stop().animate({right: '-50', opacity: 

'0'},400,'easeInCubic');		
	});
	
	$(".cycleslider-wrap").fadeIn(1000);
	$(".slider-wrap .loader").css({display: "none"});
	$("#slider").cycle({
		fx:  "scrollLeft",
		speed:  "800", 
		timeout: "5000",
		easing:  "linear",
		next:  "#cycle-next",
		prev:  "#cycle-prev",
		pager:  "#cycle-nav"
	});

});
</script>
<script  type="text/javascript">
	$(function(){
	$("img.lazy").lazyload({
		placeholder : "public/home/images/images/grey.png",
		effect : "fadeIn",
		threshold : 600
  });
});
</script>
<script type="text/javascript" src="js/test.js"></script>

<script src="js/order.js" type="text/javascript"></script>
<script src="js/utils.js" type="text/javascript"></script>

<!--title 小图标  -->
<link rel="shortcut icon" href="images/icon.png">
<!--不打开新窗口的方法  -->
<script type="text/javascript">
       window.name = "curWindow";
</script>
</head>


<body>
<div id="header" align="center">
<img src="picture/logo.png">
</div>

<!--广告图片-->
<div class="banner" align="center">
<img src="picture/banner.jpg">
</div>

<!--广告图片2-->
<div class="b_hf" align="center">
		<img src="picture/1.jpg">
</div>

<!--广告图片3-->
<div class="conten7" align="center">
		<img src="picture/2.jpg"><br />
      	<img src="picture/3.jpg"><br />
        <br /><br /><video controls="controls" poster="picture/ad1.png" src="http://opzinwpae.bkt.clouddn.com/about.mp4" width="834"></video><br /><br /><br /><br />
		
</div>


<!--广告图片4-->
<div class="b_hf" align="center">
<img src="picture/4.jpg">
</div>

<!--广告图片3-->
<div class="conten7" align="center">
		<img src="picture/5.jpg"><br />
      	<img src="picture/6.jpg"><br />
        <br /><br /><video controls="controls" poster="picture/ad2.png" src="http://opzinwpae.bkt.clouddn.com/tv.mp4" width="834"></video><br /><br /><br /><br />
</div>

<!--广告图片5-->
<div class="b_hf" align="center">
<img src="picture/7.jpg">
</div>
	
<!--广告图片8-->	
<div class="conten7" align="center">
		<img src="picture/8.jpg">
</div>
		
<!--广告图片5-->
<div class="b_hf" align="center">
<img src="picture/9.jpg">
</div>
		
<!--广告图片3-->
<div class="conten7" align="center">
		 <br /><br /><img src="picture/10.jpg"><br />
		 <br /><br /><video controls="controls" poster="picture/huang.png" src="http://opzinwpae.bkt.clouddn.com/huang.mp4" width="834"></video><br /><br />
		 <br /><br /><video controls="controls" poster="picture/huang2.png" src="http://opzinwpae.bkt.clouddn.com/xu.mp4" width="834"></video><br /><br />

      	<img src="picture/11.jpg"><br /><br />
</div>

<!--广告图片5-->
<div class="b_hf" align="center">
<img src="picture/12.jpg">
</div>
		
		
	<div class="conten2">
		<div id="order" class="center">
			
			<div id="order_form" class="on_order">
				 <h4><span>进货数量：</span></h4>
				 
	<!-- 不打开新窗口的方法  target="curWindow"  -->			 
<form action="deal_order.jsp" method="post" name="theForm" id="theForm"  target="curWindow" >

<!--隐藏参数-->
<input type="hidden" value="201" name="sp_id"></input>
<input type="hidden"  name="prurl"></input>
<input type="hidden" name="spm"></input>
<!--所选套餐         重要哈-->
<!--价格  -->
<input id="jg" type="hidden" value="" name="jg"></input>
<!--  订购的那个产品-->
<input id="suk" type="hidden" value="" name="suk"></input>


<input id="fc" type="hidden" value="" name="fc"></input>
<!--推荐人-->
<input type="hidden" value="" name="tjr"></input>
<input type="hidden" value="" name="shangjia"></input>
<input type="hidden" value="201-" name="urlid"></input>

<!--产品列表-->
<div class="chpr_list">
    <dl class="clearfix">
        <dd class="sku_dd">
        
        
        <a  data-jg="490" data-suk="微商进货价98元（490元/5盒）" data-fc="265" >  
                <input class="i_check" type="checkbox">
				<em class="f_cur" style=""><img alt="" src="picture/cur_pic03.gif"></em>
				<em class="d_cur" style=""><img alt="" src="picture/cur_pic02.gif"></em>
                <span><img src="picture/13.jpg"  height="60" width="60"></span>
                
                <span>
                <em style="font-weight:bold;font-size:14px;">微商进货价98元（5盒）</em><br />寿全斋暖贡红糖姜茶<br />
                    <em style="color:#039221;font-size:14px;font-weight:bold;padding:0 10px;">490元</em>
                 <br> </span>
                 
                 
                <div class="layer_r">
                    <div><img src="picture/layer_pic01.png" alt=""></div>
                    <div class="layer_r_box"><img  original="picture/13.jpg" alt="" height="240" width="240"><br /><br /><br />
                    <h5>微商进货价98元（5盒）</h5><br /><br />
                        <div><strong>￥490</strong></div>					
                    </div>
                    <div style="margin-left:11px;"><img src="picture/layer_pic03.png" alt=""></div>
                </div>
            </a>
			
			
			
      <a  data-jg="680" data-suk="特约进货价68元（680元/10盒）" data-fc="490" >
         <input class="i_check" type="checkbox">
		   <em class="f_cur" style=""><img alt="" src="picture/cur_pic03.gif"></em>
			<em class="d_cur" style=""><img alt="" src="picture/cur_pic02.gif"></em>
                <span><img src="picture/13.jpg"  height="60" width="60"></span>
                <span>
                    <em style="font-weight:bold;font-size:14px;">特约进货价68元（10盒）</em><br />寿全斋暖贡红糖姜茶<br />
                    <em style="color:#039221;font-size:14px;font-weight:bold;padding:0 10px;">680元</em>
                 <br></span>
                 
                <div class="layer_r">
                    <div><img src="picture/layer_pic01.png" alt=""></div>
                    <div class="layer_r_box">
                        <img  original="picture/13.jpg" alt="" height="240" width="240"><br /><br />
                        <h5>特约进货价68元（10盒）</h5><br><br>               
                        <div><strong>￥680</strong></div>
                    </div>
                    <div style="margin-left:11px;"><img src="picture/layer_pic03.png" alt=""></div>
                </div>
            </a>		
			
			
			
	<a  data-jg="2800" data-suk="一级进货价56元（2800元/50盒）" data-fc="108" >
       <input class="i_check" type="checkbox">
	<em class="f_cur" style=""><img alt="" src="picture/cur_pic03.gif"></em>
	 <em class="d_cur" style=""><img alt="" src="picture/cur_pic02.gif"></em>
      <span><img src="picture/13.jpg"  height="60" width="60"></span>
       <span>
          <em style="font-weight:bold;font-size:14px;">一级进货价56元（50盒）</em><br />寿全斋暖贡红糖姜茶<br />
          <em style="color:#039221;font-size:14px;font-weight:bold;padding:0 10px;">2800元</em>
        <br>
      </span>
      
     <div class="layer_r">
      <div><img src="picture/layer_pic01.png" alt=""></div>
       <div class="layer_r_box">
       <img  original="picture/13.jpg" alt="" height="230" width="255">
       <h5>一级进货价56元（50盒）</h5>
       <div><strong>￥2800</strong></div>
        </div>
       <div style="margin-left:11px;"><img src="picture/layer_pic03.png" alt=""></div>
        </div>
     </a>  
   
   
      
        </dd>
		<dd class="clear"></dd>
    </dl>  
    
    
    <input id="item_num" type="hidden" value="0" name="num">
	<div id="calculate_price" > 
	<b style="color:#FF0000;">商品总价：</b><span id="item_price">￥0</span>元</div>
</div>



<script type="text/javascript">
	$(".sku_dd a").bind("click",function(){ 
			var o = $(this);
			if(!o.hasClass("cur")){
				$(".cur").removeClass("cur");
				o.addClass("cur");
				/*更新对应的选中尺码的数据*/
				$("#item_price").html("￥"+ o.attr("data-jg"));
				$("#item_num").val(o.attr("data-jg"));
				$("#suk").val(o.attr("data-suk"));
				$("#fc").val(o.attr("data-fc"));
				$("#jg").val(o.attr("data-jg"));
		/* 		//价格
				var price=o.attr("data-jg");
				//订购的商品
				var product=o.attr("data-suk");
				alert(price+product);
			 */
			}
		});
</script>


<div class="car_list"></div>
<!--<h4 id="fav_title"><span>优惠活动：</span></h4>-->
<div class="w924" style="margin-top:15px;">
    <div class="yh_act favourable_list">
    </div>							

		
<div class="paykind">
    <h6>收货信息</h6>
        <div class="paykind_box01" id="checkout_form_box">
            <ul>
                <li>
                    <label>收货人姓名：</label>
                    <!--  dvalue="请输入收货人姓名"-->
                    <input class="col_c"   name="name" id="name" onblur="consigneeSet(this.value)" size="30" autocomplete="off">
                    <span id="consignee_notice"></span>
                </li>
                
<script type="text/javascript" src="js/bddq.js" charset="gb2312"></script>
                <li>
                    <label>地址：</label>
                     <select name="bdprovince" class="bddqxl" id="bdprovince"  ></select>
                                                      省份/直辖市
				     <select name="bdcity" class="bddqxl"  id="bdcity"></select>
				            市
					 <select name="bdarea" class="bddqxl" id="bdarea"></select>
					<span id="flow_notice"></span>	
					
						
<script type="text/javascript" src="js/bdbd.js"></script>
  			    </li>
  			    
                <li>
                    <label>详细地址信息:</label>
                    <input class="col_c" style="width:310px" name="address" id="address" onblur="addressSet(this.value)" size="40" maxlength="120"  type="text" autocomplete="off">
                    <span id="address_notice"></span>
                </li>
                
                <li>
                    <label>联系电话：</label>
                   <!--  dvalue="手机号或区号-固话" -->
                    <input class="col_c"  name="mob" id="tel" maxlength="13"  size="30" autocomplete="off">
                     <span id="mobile_notice"></span>
                </li>
                
            </ul>
        </div>
        
        <h6>支付方式</h6>
        <div class="paykind_box02">
            <!--<label>
                <input onclick="javascript:select_pay(4);" value="4" name="pay_id" 

id="payid_4" checked="checked" type="radio">支付宝支付<img 

src="picture/pay_pic01.jpg">
            </label><br>-->
            <!--<label>
            <input type="radio" onclick="javascript:select_pay(17);" value="17" 

name="pay_id" id="payid_17"/>网银支付（折上再享95折）<img 

src="picture/pay_pic02.jpg">
            </label><br/>
            <label>
            <input type="radio" onclick="javascript:select_pay(8);" value="8" name="pay_id" 

id="payid_8"/>快钱支付（折上再享95折）<img src="picture/pay_pic04.png">
            </label><br/>-->
            
            
            <label>
            <input onclick="javascript:select_pay(1);" value="货到付款" name="zhifubao" type="radio"  checked="checked">
                               货到付款</label>
                               
<script type="text/javascript" src="get_prevent_refresh867b.html?t=1441175749"></script>

    <span id="pay_id_notice"></span>
        </div>
		    </div>

          <div class="special_n">如果您有特殊要求，请在这里注明：
          <textarea name="guest" id="liuyan"></textarea>
          </div>
         <div class="payform_btn text_center">
         <input onclick="this.submit()"  src="picture/click_btn04.jpg" id="check_submit"  type="image">
         </div>
        </div>
        
        
</form>

<script type="text/javascript">
 $("#check_submit").click(function () {
 //前端校验
  if(!validate_add_form()){
        return false;
    }
 });
 
  function validate_add_form(){
     var  productname=$("#suk").val();
     var  price=$("#jg").val();
     if(price==""||productname==""||price==null||productname==null){
    alert("产品为空！");
      return false;
   }
   else{
   var name=$("#name").val();
   if(name==""||name==null){
   alert("收货人姓名为空！");
     return false;
   }
   else{
    var bdprovince=$("#bdprovince").val();
    var bdcity=$("#bdcity").val();
    var bdarea=$("#bdarea").val();
    var address=$("#address").val();
    var addressALL=bdprovince+bdcity+bdarea+address;
    if(addressALL==""||addressALL==null) {
       alert("收货地址为空！");
         return false;
    }
    else{
       var tel=$("#tel").val();
       if(tel==""||tel==null){
       alert("联系方式为空！");
         return false;
       }
       
       
    }
   
   }
   }
  
     
return true;
}
</script>

<script language="JavaScript">
    $(".chpr_list a").hover(function(){
        var thisImg = $(this).children(".layer_r").children(".layer_r_box").find("img");
        thisImg.attr("src",thisImg.attr("original"));
    },function(){
    });
</script>		
			</div>
			
		</div>
	</div>
</div>

<div class="mini_nav">
<div style=" width:1000px; height:70px; background:url(images/phone.jpg) no-repeat left;  margin:0 auto;">
<table width="1000" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="500"></td>
    <td width="500" align="left">
	<div  style=" padding-top:0px; padding-top:32px;color:#c8b16c; font-family:Arial, Helvetica, sans-serif; font-size:30px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;400-998-7332</div></td>

  </tr>
</table>

 </div>

		
  <span style="font-size:30px;padding:5px;color:yellow;vertical-align: middle;"></span>
		
</div>

<script language="javascript">
	//咨询
    function zixun(){
    	alert(1);
    }

</script>
	
<script type="text/javascript">
    $(function (){
        $("#checkout_form_box input").focus(function(){
            $(this).removeClass("col_c");
            $(this).addClass("col_b");
            $(this).addClass("redBd");
        })
        $("#checkout_form_box input").blur(function(){
            $(this).removeClass("redBd");
            if(!$(this).val() || $(this).val() == $(this).attr('dvalue')){
                $(this).removeClass("col_b");
                $(this).addClass("col_c");
                $(this).val($(this).attr('dvalue'));
            }
        })
	    $("#checkout_form_box input").each(function(){
	        if($(this).val() && $(this).val() != $(this).attr('dvalue')){
	            $(this).removeClass("col_c");
	        }
	    });
    });

</script>
<script language="javascript" type="text/javascript" src="js/19259653.js"></script>

<noscript>
<a href="//www.51.la/?19259653" target="_blank">
<img alt="&#x6211;&#x8981;&#x5566;&#x514D;&#x8D39;&#x7EDF;&#x8BA1;" src="picture/19259653.asp" style="border:none" />
</a>
</noscript>

</body>
</html>