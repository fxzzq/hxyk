package com.xzq.curd.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzq.curd.bean.Employee;
import com.xzq.curd.bean.Msg;
import com.xzq.curd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*处理员工增删改查crud 请求
* */
@SuppressWarnings("ALL")
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
/*
*单个 批量 二合一
*批量删除：1-2-3
* 单个：1
*
* */
    @SuppressWarnings("InfiniteLoopStatement")
    @ResponseBody
    @RequestMapping(value = "/emp/{ids}",method=RequestMethod.DELETE)
    public Msg deleteEmp(@PathVariable("ids") String ids){
        //批量删除
        if (ids.contains("-")){
            List<Integer> del_ids=new ArrayList<Integer>();
            String[] str_ids = ids.split("-");
            //组装id集合
            for (String string: str_ids){

                del_ids.add(Integer.parseInt(string));
            }
            employeeService.deleteBatch(del_ids);


        }
        //单个删除
        else {
           Integer id=Integer.parseInt(ids);
            employeeService.deleteEmp(id);
        }

        return Msg.success();
    }


     /*
     * 保存更改后的员工数据(更新方法)
     * id必须是empId
     *如果直接发送ajax=PUT形式的请求
     * 封装的数据
     * Employee  [empId=1033  empName=null  gender=null  email=null  dId=null]
     * 问题
     * 请求体中有数据
     * 但是Employee对象封装不上
     * sql拼接语句变成：    update tb1_emp      where emp_id = 1033
     * 原因
     * tomcat :
     *        1、将请求体中的数据，封装成一个map
     *         2、request.getParamter("empName")就会从这个map中取值
     *         3、Springmvc封装POJO对象的时候
     *            会把POJO中每个属性的值，(调用  )request.getParamter("email")
     *
     *       Ajax发送PUT请求引发的血案 （不能直接发）
     *       PUT请求，请求体中的数据 request.getParamter("empName")拿不到
     *       tomcat一看是put 不会封装请求体中的数据为map 只有post形式的请求才封装请求体为map
     *
     *      解决办法
     *       可直接发送put请求还要封装请求体内的数据
     *       配置后HttpPutFormContentFilter
     *       他的作用：他将请求体的数据解析包装成一个map
     *                 request被重新包装 request.getParamter()被重写
     *                 就会从自己封装的map中取数据
     *
     * */
     @ResponseBody
    @RequestMapping(value = "/emp/{empId}",method = RequestMethod.PUT)
     public Msg saveEmp(Employee employee,  HttpServletRequest request){
         //用原生的估计都不行
         System.out.println("请求体中的数据："+request.getParameter("gender"));
         System.out.println("将要个更新的员工数据:"+employee);
        employeeService.updateEmp(employee);
     return Msg.success();
     }

    /*
    * 查询根据id查询员工信息
    *
    * */
    @RequestMapping(value = "/emp/{id}",method =RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("id") Integer id){
     Employee  employee= employeeService.getEmp(id);
        return Msg.success().add("emp",employee);

    }

     /*
     * 校验用户名是否可用
     * */
     @ResponseBody
     @RequestMapping(value = "/check",method =RequestMethod.POST)
     public  Msg check(@RequestParam(value = "empName",required= true) String empName){
         //先判断输入的是不是合法的用户名 表达式
          String regx="(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
         if(!empName.matches(regx)){
             return Msg.fail().add("va_msg","用户名可以是6-16位英文和数字的组合或者2-5位中文");
         }

         System.out.println("12333");
         System.out.println("接收参数："+empName);
        boolean b=employeeService.checkUser(empName);
        if (b){
             return Msg.success();
        }else {
            return Msg.fail().add("va_msg","用户名不可用");

        }

     }

     /*
     * 员工保存
     * ResponseBody 返回json 数据
     *
     * 校验  @Valid   BindingResult result
     * */


     @RequestMapping(value = "/emp",method =RequestMethod.POST)
     @ResponseBody
      public  Msg saveEmp(@Valid Employee employee , BindingResult result){
         System.out.println("------后端开始验证------");
         if(result.hasErrors()){

             //校验失败 应该返回失败 在模态框中显示校验失败的错误信息
             Map<String,Object> map=new HashMap<String, Object>();
            List<FieldError> errors=result.getFieldErrors();
            for(FieldError fieldError:errors){

                System.out.println("错误的字段名："+fieldError.getField());
                System.out.println("错误信息："+fieldError.getDefaultMessage());
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
             System.out.println("------后端验证失败------");
             return Msg.fail().add("errorFields",map);
         }
         else {
             System.out.println("------后端验证成功------");
             employeeService.saveEmp(employee);
             System.out.println("------后端结束验证------");
             return Msg.success();

         }

      }


  /*
  * ResponseBody要正常工作 需导入jackson包
  * */



    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam (value = "pn",defaultValue = "1")Integer pn){
        //这不是一个分页查询
        //引入PageHelpler分页插件 并注册
        //查询之前只需调用，插入页码，以及每页的大小
        PageHelper.startPage(pn,5);
        //现在startPage紧跟着的查询就是一个分页查询。
        List<Employee> emps= employeeService.getALL();
        //使用PageInfo包装查询后的结果，只需要将pageInfo交给页面就行了
        //封装了详细的分页信息，包括有我们查询出来的数据 ,传入连续显示的页数
        PageInfo page=new PageInfo(emps,5);
        return Msg.success().add("pageInfo",page);
    }

    /*
    * 查询员工数据 (分页查询)
    * */

   //@RequestMapping("/emps")
    public String getEmps(@RequestParam (value = "pn",defaultValue = "1")Integer pn,Model model){
       //这不是一个分页查询
       //引入PageHelpler分页插件 并注册
        //查询之前只需调用，插入页码，以及每页的大小
       PageHelper.startPage(pn,5);
       //现在startPage紧跟着的查询就是一个分页查询。
       List<Employee> emps= employeeService.getALL();
       //使用PageInfo包装查询后的结果，只需要将pageInfo交给页面就行了
       //封装了详细的分页信息，包括有我们查询出来的数据 ,传入连续显示的页数
       PageInfo page=new PageInfo(emps,5);
        model.addAttribute("pageInfo",page);
    return "list";
    }

}

