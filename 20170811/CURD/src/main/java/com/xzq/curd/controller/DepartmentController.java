package com.xzq.curd.controller;

import com.xzq.curd.bean.Department;
import com.xzq.curd.bean.Msg;
import com.xzq.curd.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author:xzq
 * @Descripition:处理和部门有关的请求
 * @Date: Created in 4:04 2017/8/8
 * @Modified:
 */
@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    /*
    * 返回所有的部门信息
    * */
    @RequestMapping("/depts")
    @ResponseBody
    public Msg getsDepts(){
        //查询的所有部门信息
        List<Department> list=departmentService.getDepts();
        return  Msg.success().add("depts",list);
    }
}
