import com.xzq.curd.bean.Department;
import com.xzq.curd.bean.Employee;
import com.xzq.curd.dao.DepartmentMapper;
import com.xzq.curd.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/*
* 测试dao层的工作
*  推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
*  1、导入springTest模块
*  2、@ContextConfiguration指定spring配置文件的位置 自动创建所需容器
*  3、直接autowired要使用的组件即可 自动注入
* */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Mappertest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;
        /*
        *  测试DepartmentMapper
        */

    @Test
    public void testCURD(){
        /*  //原生的方式
        //创建springIOC容器
        ApplicationContext ioc= new ClassPathXmlApplicationContext("applicationContext.xml");
       //从容器中获得mapper
        DepartmentMapper bean=ioc.getBean(DepartmentMapper.class);
        */

        System.out.println(departmentMapper);
        //1、插入几个部门
          //  departmentMapper.insertSelective( new Department(null,"开发部"));
         //  departmentMapper.insertSelective( new Department(null,"测试部"));
        // 2、生成员工数据，测试员工插入
       //   employeeMapper.insertSelective(new Employee(1,"Jerry","M","Jerry@xzq.com",1));
        //3、批量插入多个员工 批量 使用可以执行批量操作的sqlSession
        //  sqlSession  后来项目中可能也会用到。所以在ioc中配置一个可以批量操作sqlSession

      /*  for (int i = 0; i < 1000; i++) {
            employeeMapper.insertSelective(new Employee(1,"Jerry","M","Jerry@xzq.com",1));
        }*/
         EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {

           String  uid= UUID.randomUUID().toString().substring(0,5)+i;
            mapper.insertSelective(new Employee(null,uid,"M",uid+"@xzq.com",1));
        }
        System.out.println("批量完成！");
    }
}
