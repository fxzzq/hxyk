package com.xzq.curd.service;

import com.xzq.curd.bean.Employee;
import com.xzq.curd.bean.EmployeeExample;
import com.xzq.curd.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {

/*自动装配service的逻辑业务*/
    @Autowired
    EmployeeMapper employeeMapper;
    /*查询所有员工*/
    public List<Employee> getALL(){
        return employeeMapper.selectByExampleWithDept(null);

    }
    /*
    * 员工保存方法
    * */
      public void  saveEmp(Employee employee){
          employeeMapper.insertSelective(employee);

      }
        /*
        *检验用户名是否可用
        * */
    public boolean checkUser(String empName){

        EmployeeExample example=new EmployeeExample();

        System.out.println("abcd checkuser start");
      EmployeeExample.Criteria criteria=example.createCriteria();
        System.out.println("此时的值："+empName);

        // select count(*) from tb1_emp WHERE  emp_name=?
             criteria.andEmpNameEqualTo(empName);
          //  example.or().andEmpNameEqualTo(empName);
            long count= employeeMapper.countByExample(example);
       System.out.println("count:"+count);
       if (count==0){
           return  true;
       }
       else {
           return false;
       }

    }
    /*
    *按照员工id 查询员工
    *
    * *  */

    public Employee getEmp(Integer id) {
      Employee employee=  employeeMapper.selectByPrimaryKey(id);
     return employee;
    }


    /*
    * 员工更新
    * */
    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }



    /*
    * 员工删除
    * */
    public void deleteEmp(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Integer> ids) {
        EmployeeExample example=new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();

        //andEmpIdIn(List<Integer>  values )
        //delete  from xxx where emp_id in(1,2,3)
        criteria.andEmpIdIn(ids);
        employeeMapper.deleteByExample(example);
    }
}
