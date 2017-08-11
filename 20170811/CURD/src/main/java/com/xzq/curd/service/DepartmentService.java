package com.xzq.curd.service;


import com.xzq.curd.bean.Department;
import com.xzq.curd.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:xzq
 * @Descripition:
 * @Date: Created in 4:08 2017/8/8
 * @Modified:
 */
@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;
    public List<Department> getDepts(){
        List<Department> list=departmentMapper.selectByExample(null);
        return  list;
    }

}
