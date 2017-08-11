<%--/*@author: xzq
*@Descripiton:
*@date:22:48 2017/8/7
*/--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <%--
    不以/开始的相对路径 找资源，以当前资源的路径为基准 经常出问题
    以/开始的相对路径 找资源 以服务器的路径为标准(  http://localhost:3306),需加上项目名
              http://localhost:3306/crud
    --%>
    <script src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>

    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 员工修改的模态框 -->
<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >员工修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <%--员工姓名是静态框 去掉input标签 加入p标签--%>
                            <p class="form-control-static" id="empName_update_static"></p>
                            <%--<input type="text" name="empName" class="form-control" id="empName_update_input" placeholder="empName">
                            <span  class="help-block"></span>--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="text" name="email" class="form-control" id="email_update_input" placeholder="email@xzq.com">
                            <span  class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1_update_input" value="M" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2_update_input" value="F"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">

                            <%--部门提交dId即可--%>
                            <%--  注意
                            这里应该是dId  写成deptId--%>
                            <select class="form-control" name="dId" id="dept_add_select">
                            </select>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
            </div>
        </div>
    </div>
</div>


<!-- 员工添加的模态框 -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">员工添加</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <input type="text" name="empName" class="form-control" id="empName_add_input" placeholder="empName">
                            <span  class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="text" name="email" class="form-control" id="email_add_input" placeholder="email@xzq.com">
                            <span  class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1_add_input" value="M" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2_add_input" value="F"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">

                            <%--部门提交dId即可--%>
                                <%--  注意
                                这里应该是dId  写成deptId--%>
                            <select class="form-control" name="dId" id="dept_add_select">
                            </select>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>




<div class="container">
    <%--标题--%>
    <div class="row">
        <div class="col-md-12">
            <h1>SSM-CRUD</h1>
        </div>
    </div>
    <%--按钮--%>
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary" id="emp_add_modal_btn">新增</button>
            <button class="btn btn-danger" id="emp_delete_all_btn">删除</button>
        </div>
    </div>
    <%--显示表格数据--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="emps_table">
                <thead>
                <tr>
                    <th>
                        <input type="checkbox" id="check_all"/>
                    </th>
                    <td>#</td>
                    <td>empName</td>
                    <td>gender</td>
                    <td>email</td>
                    <td>deptName</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>
    <%--显示分页信息--%>
    <div class="row" >
        <%--分页文字信息--%>
        <div class="col-md-6" id="page_info_area">

        </div>

        <%--分页条信息--%>
        <div class="col-md-6" id="page_nav_area">
        </div>

    </div>
</div>
<script type="text/javascript">
    var totalRecord;
    var currPage;
  //页面加载完成后，直接去发送ajax请求 要到分页数据
    $(function () {
        //去首页
        to_page(1);
    });
    //跳转到指定的页码号
       function to_page(pn) {
           $.ajax({
               url:"${APP_PATH}/emps",
               data:"pn="+pn,        //写错成了date
               type:"GET",
               success:function (result) {
                   // console.log(result);
                   //1、解析并显示员工数据
                   build_emps_table(result);
                   //2、解析并显示分页信息
                   build_page_info(result);
                   //3、解析并显示分页条数据
                   build_page_nav(result);


               }
           });
       }




             function  build_emps_table(result) {
               //清空table表格
                $("#emps_table tbody").empty();

               var emps=result.extend.pageInfo.list;
               $.each(emps,function (index,item) {
                 //  alert(item.empName);
                   var checkBoxTd=  $("<td><input type='checkbox' class='check_item'></td>");
                   var empIDTd =    $("<td></td>").append(item.empId);
                   var empNameTd =  $("<td></td>").append(item.empName);
                   var gender=      $("<td></td>").append(item.gender=='M'?"男":"女");
                   var emailTd =    $("<td></td>").append(item.email);
                   var deptNameTd = $("<td></td>").append(item.department.deptName);
                   //editBtn 添加class ---edit_btn
                   var editBtn=     $("<button></button>").addClass("btn btn-primary  btn-sm  edit_btn")
                                     .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
                   //为编辑按钮添加一个自定义属性，来表示当前员工id
                   editBtn.attr("edit-id",item.empId);
                   var delBtn=      $("<button></button>").addClass("btn btn-danger  btn-sm  delete_btn")
                                     .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
                   //为删除按钮添加一个自定义属性，来表示当前员工id
                   delBtn.attr("delete-id",item.empId);
                   var  btnTd=$("<td></td>").append(editBtn).append("  ").append(delBtn);
                  //append 方法执行完成后还是返回原来的元素
                   $("<tr></tr>").append(checkBoxTd)
                                 .append(empIDTd)
                                 .append(empNameTd)
                                 .append(gender)
                                 .append(emailTd)
                                 .append(deptNameTd)
                                 .append(btnTd)
                       .appendTo("#emps_table tbody");

               });
             }
             //解析显示分页信息
              function build_page_info(result) {
               //清空分页信息
                 $("#page_info_area").empty();

                    $("#page_info_area").append(" 当前"+result.extend.pageInfo.pageNum
                                                +"页,总" +result.extend.pageInfo.pages
                                                +"页,总"+result.extend.pageInfo.total+"记录")
                  totalRecord=result.extend.pageInfo.total;
                    currPage=result.extend.pageInfo.pageNum;
                }
             //解析显示分页条
             //  点击分页要能去下一页。。。。。
             function build_page_nav(result) {
               //清空分页条
                 $("#page_nav_area").empty();

                 //page_nav_area &laquo;
                 //构建元素
                 var ul=$("<ul></ul>").addClass("pagination");
                 var firstPageLi= $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
                 var prePageLi=   $("<li></li>").append($("<a></a>").append("&laquo;"));

                 if(result.extend.pageInfo.hasPreviousPage==false){
                     firstPageLi.addClass("disabled");
                     prePageLi.addClass("disabled");
                 }else {
                     //给元素添加点击翻页的事件
                     firstPageLi.click(function () {
                         to_page(1);
                     });
                     prePageLi.click(function () {
                         to_page(result.extend.pageInfo.pageNum-1);
                     });
                 }




                 var nextPageLi=   $("<li></li>").append($("<a></a>").append("&raquo;"));
                 var lastPageLi= $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
                 if(result.extend.pageInfo.hasNextPage==false){
                     nextPageLi.addClass("disabled");
                     lastPageLi.addClass("disabled");
                 }else{
                     lastPageLi.click(function () {
                         to_page(result.extend.pageInfo.pages);
                     });
                     nextPageLi.click(function () {
                         to_page(result.extend.pageInfo.pageNum+1);
                     });
                 }




                 //构造首页和前一页的提示
                 ul.append(firstPageLi).append(prePageLi);

                 //遍历页码号1、2、3、4、5 给ul添加页码提示
                 $.each(result.extend.pageInfo.navigatepageNums,function (index,item) {

                    var numLi= $("<li></li>").append($("<a></a>").append(item));
                    if(result.extend.pageInfo.pageNum==item){
                        numLi.addClass("active");
                    }
                    //给li添加点击事件
                  numLi.click(function () {
                      to_page(item);
                  });
                    ul.append(numLi);
                 });
                 //构造后一页和末页的提示
                 ul.append(nextPageLi).append(lastPageLi);

                 var navEle=$("<nav></nav>").append(ul);
                 navEle.appendTo("#page_nav_area");
             }

              //清除表单及内容
                  function reset_form(ele) {
                      //jquery没有reset方法  取出dom对象
                      //清除表单数据
                        $(ele)[0].reset();
                        //清除表单输入框的样式
                       $(ele).find("*").removeClass("has-error  has-success");
                       //清除表单提示的样式
                      $(ele).find(".help-block").text("");
                  }


                //点击新增按钮   弹出模态框
             $("#emp_add_modal_btn").click(function () {
                  // 表单完整重置（清除表单数据 和 表单的样式 ）
                    reset_form( "#empAddModal form");



                 //发送ajax请求 弹出部门信息，显示在下拉列表中
                    getDepts("#empAddModal select");

                  //弹出模态框
                 $("#empAddModal").modal({
                     backdrop:"static"
                 });
             });
       
                function  getDepts(ele) {
                    $.ajax({
                        url:"${APP_PATH}/depts",
                        type:"GET",
                        success:function (result) {
                          //  {"code":100,"msg":"处理成功！","extend":{"depts":[{"deptId":1,"deptName":"开发部"},{"deptId":2,"deptName":"测试部"},{"deptId":17,"deptName":"开发部"},{"deptId":18,"deptName":"测试部"}]}}
                            //console.log(result);
                            //显示部门信息在列表中
                            // #dept_add_select 通过id也能找到
                             //因为模态框下只有一个select标签 所以也能找到  #empAddModal select

                            //清除当前元素的格式
                            $(ele).empty();


                            //function 可以带参数 也可不带（this）
                            $.each(result.extend.depts,function () {

                               var optionEle=$("<option></option>").append(this.deptName).attr("value",this.deptId);
                               optionEle.appendTo(ele);
                            });

                        }
                    });
                    
                }
                   //校验表单数据
                   function validate_add_form() {
                        //拿到要校验的数据  使用正则表达式
                       var empName=$("#empName_add_input").val();
                       var regName=/(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5}$)/;
                       //测试
                      // alert(regName.test(empName));
                       if(!regName.test(empName)){
                        //   alert("用户名可以是2-5中文或者6-16位英文和数字的组合");
                           show_validate_msg("#empName_add_input","error","用户名可以是2-5中文或者6-16位英文和数字的组合");
                           return false;
                       }else {
                           show_validate_msg("#empName_add_input","success","");

                       };
                       //校验邮箱
                        var email=$("#email_add_input").val();
                        var  regEmail=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
                        if(!regEmail.test(email)){
                            // alert("邮箱格式不正确");

                            show_validate_msg("#email_add_input","error","邮箱格式不正确");
                             return false;
                        }else {
                            show_validate_msg("#email_add_input","success","");
                        };
                       return  true ;
                   }

       //显示检验结果的提示信息
       function  show_validate_msg(ele,status,msg) {

              //  自己写  要所有信息都正确了才清空

                 //应该清空当前元素之前的样式  检验状态
                 $(ele).parent().removeClass("has-error  has-success");
                 $(ele).next("span").text("");




           if("success"==status){
               $(ele).parent().addClass("has-success");
               $(ele).next("span").text(msg);
           }
           else if("error"==status){
               $(ele).parent().addClass("has-error");
               $(ele).next("span").text(msg);
           }
       }


         //检验用户名是否可用

        $("#empName_add_input").change(function () {
            //发送ajax请求检验用户名是否可用
            var  empName=this.value;
            //alert(empName);
            $.ajax({
                url:"${APP_PATH}/check",
                data:"empName="+empName,    //写错成了date
                type:"POST",
                success:function (result) {
                    if(result.code==100){
                        show_validate_msg("#empName_add_input","success","用户名可用");
                        //给保存按钮自定义属性 和value
                        $("#emp_save_btn").attr("ajaxUserVa","success");
                    }else {
                        show_validate_msg("#empName_add_input","error",result.extend.va_msg);
                        //用户名不可用  不能保存
                        $("#emp_save_btn").attr("ajaxUserVa","error");
                    }
                }
            });
        });






                //保存按钮的绑定事件
                $("#emp_save_btn").click(function () {
                  //1、模态框中填写的表单数据交给服务器进行保存

                  //先对要提交给服务器的数据进行校验
                    //------前端校验 核心 可以注释绕过---------
                    if(!validate_add_form()){
                        return false;
                    };

                    //2、判断之前的ajax用户名校验是否成功  如果成功 往下走
                   if($(this).attr("ajaxUserVa")=="error"){
                       return false;
                   };


                  //3、发送ajax请求 保存员工

                    //序列表表格内容为字符串
              //    alert($("#empAddModal form").serialize());
                    $.ajax({
                        url:"${APP_PATH}/emp",
                        type:"POST",
                        data:$("#empAddModal form").serialize(),
                        success:function (result) {
                         //   alert(result.msg);
                       if(result.code==100){
                           //员工保存成功
                           //1、关闭模态框
                           $("#empAddModal").modal("hide");
                           //2、来到最后一页 显示刚才保存的数据
                           //发送ajax请求显示最后一页数据即可。
                           to_page(totalRecord);
                       }
                       else{
                           //显示失败信息
                           //console.log(result);
                           //有哪个字段的错误信息就显示哪个字段
                            //alert(result.extend.errorFields.email);
                           //alert(result.extend.errorFields.empName);
                           if (undefined !=result.extend.errorFields.email){
                                  //显示邮箱的错误信息
                               show_validate_msg("#email_add_input","error",result.extend.errorFields.email);
                           }
                           if (undefined !=result.extend.errorFields.empName){
                               //显示名字的错误信息
                               show_validate_msg("#empName_add_input","error",result.extend.errorFields.empName);

                           }
                       }

                        }
                    });
                });

                           //1、我们是按钮创建就绑定了click 所以绑不上
                             /* $(".edit_btn").click(function () {
                                  alert("edit");
                              });*/
                            //1)、可以在创建按钮的时候绑定 2)绑定. live()
                             //jquery 新版 没有live方法，使用on 替换
                            /*
                            * 更新前 编辑员工信息
                            * */
                            $(document).on("click",".edit_btn",function () {
                                //alert("edit");

                                 //1、查询部门信息 显示部门列表
                                getDepts("#empUpdateModal select");
                                //2、查出员工信息 并显示员工信息
                                //员工姓名 是静态框  <p class="form-control-static">email@example.com</p>
                                getEmp($(this).attr("edit-id"));
                                //3、把员工的id传递给模态框的更新按钮
                                $("#emp_update_btn").attr("edit-id",$(this).attr("edit-id"));

                                 //弹出模态框
                                $("#empUpdateModal").modal({
                                    backdrop:"static"
                                });
                            });

                            function  getEmp(id) {
                                $.ajax({
                                      url:"${APP_PATH}/emp/"+id,
                                      type:"GET",
                                success:function (result) {
                                    //console.log(result);

                                    var empData=result.extend.emp;
                                    $("#empName_update_static").text(empData.empName);
                                    $("#email_update_input").val(empData.email);
                                    $("#empUpdateModal input[name=gender]").val([empData.gender]);
                                    $("#empUpdateModal select").val([empData.dId]);
                                }
                                });
                            }

                        //点击更新 更新员工数据
                            $("#emp_update_btn").click(function () {

                                //1、校验邮箱信息
                                var email=$("#email_update_input").val();
                                var  regEmail=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
                                if(!regEmail.test(email)){
                                    show_validate_msg("#email_update_input","error","邮箱格式不正确");
                                    return false;
                                }else {
                                    show_validate_msg("#email_update_input","success","");
                                }
                                //2、发送ajax请求保存更新的员工数据
                                 //使用Rest风格的URI,
                                // HiddenHttpMethodFilter将普通的post请求转为指定的delete或put请求
                                    $.ajax({
                                        url:"${APP_PATH}/emp/"+$(this).attr("edit-id"),
                                        //type:"POST",
                                      //  data:$("#empUpdateModal  form").serialize()+"&_method=PUT",
                                        type:"PUT",
                                         data:$("#empUpdateModal  form").serialize(),
                                        //也可以直接发put
                                       success:function (result) {
                                       // alert(result.msg);
                                           //1、关闭对话框
                                           $("#empUpdateModal").modal("hide");
                                           //2、回到本页面
                                           to_page(currPage);
                                       }
                                    });
                            });

                            /*删除单个*/
                      $(document).on("click",".delete_btn",function () {
                            //弹出是否确实删除对话框  第3个<td>
                        //  alert($(this).parents("tr").find("td:eq(2)").text());
                          var empName=$(this).parents("tr").find("td:eq(2)").text();
                          var empId=$(this).attr("delete-id");
                          if(confirm("确认删除【"+empName+"】吗？")){
                                 //确认，发送ajax请求
                              $.ajax({
                                  url:"${APP_PATH}/emp/"+empId,
                                    type:"DELETE",
                                  success:function (result) {
                                      alert(result.msg);
                                       //回到本页面
                                      to_page(currPage);
                                  }
                              });
                          }
            });

            /*
            * 完成全选/全不选功能
            * */
          $("#check_all").click(function () {
             // alert($(this).attr("checked"));
            //  attr获取checked是undifined;
              //我们这些dom原生的属性，attr获取自定义属性的值
              //prop修改和读取dom原生属性的值
            // alert($(this).prop("checked"));
              $(".check_item").prop("checked",$(this).prop("checked"));
          });
          /*
          * check_item
          * */
          $(document).on("click",".check_item",function () {
                //判断当前选择中的元素是否为5个
               // alert($(".check_item:checked").length);
           var flag= $(".check_item:checked").length==$(".check_item").length;
                 $("#check_all").prop("checked",flag);

          });
          /*批量删除*/
         $("#emp_delete_all_btn").click(function () {
             var empNames="";
             var del_idstr="";
             $.each($(".check_item:checked"),function () {
                // alert($(this).parents("tr").find("td:eq(2)").text());
                 //组装员工name的字符串
                 empNames += $(this).parents("tr").find("td:eq(2)").text()+",";
                 //组装员工id的字符串
                 del_idstr +=$(this).parents("tr").find("td:eq(1)").text()+"-"
             })
             //去除empNames多余的，
             empNames= empNames.substring(0,empNames.length-1);
             //去除员工id多余的-
             del_idstr=del_idstr.substring(0,del_idstr.length-1);
             if(confirm("确认删除【"+ empNames+"】吗?")){
                 //发送ajax请求delete
                 $.ajax({
                     url:"${APP_PATH}/emp/"+del_idstr,
                     type:"DELETE",
                     success:function (result) {
                       alert(result.msg);
                       //回到当前页面
                         to_page(currPage);
                     }
                 });

             }
         });
</script>

</body>
</html>
