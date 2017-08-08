package com.rico.demo.ui;

import com.rico.demo.entities.Student;
import com.rico.demo.service.ServiceException;
import com.rico.demo.service.StudentService;
import com.rico.demo.service.StudentServiceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * UI(UserInterface) -> Service
 * Service -> Dao(Data Access Object)
 *
 * A -> B
 * Created by Rico on 2017/8/7.
 */
public class StudentUI {

    private StudentService studentService = new StudentServiceImpl();

    private static String[] menus = {
            "1 新增学生信息",
            "2 修改学生信息",
            "3 删除学生信息",
            "4 查询一个学生信息",
            "5 查询学生信息",
            "6 删除多个学生信息",
            "7 新增学生信息（Log）",
            "8 查询一个学生的信息（名字）",
            "其他 退出",
    };

    /**
     * System.in
     * System.out
     * System.err
     * 以上3个是系统输入输出流，不关闭。
     * @return
     */
    private static String input () {

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            return bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private void doNew() {
        System.out.println("new");
        System.out.println("请输入新增学生的名字：");
        String name = input();
        System.out.println("请输入新增学生的年龄：");
        String age = input();

        try {
            int i = this.studentService.newStudent(name, age);
            System.out.println("新增学生信息成功，影响行数 = " + i);
        } catch (ServiceException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            //e.printStackTrace();
            System.err.println("新增学生信息失败。");
            System.err.println("程序出错，请稍后再试|联系管理员。");
        }

    }

    private void doModify() {
        System.out.println("modify");
        System.out.println("请输入要修改学生的ID：");
        String id = input();

        try {
            Student student = this.studentService.getStudent(id);
            if(student == null) {
                System.out.println("无此ID = " + id + "学生信息");
            } else {
                System.out.println("请输入学生新的名字：");
                String name = input();
                System.out.println("请输入学生新的年龄：");
                String age = input();

               int i =  this.studentService.modifyStudent(name, age, student);

                System.out.println("修改学生信息成功，影响行数 i = " + i);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void doRemove() {
        System.out.println("remove");
    }

    private void doQuery() {
//        System.out.println("query");

        System.out.println("请输入你要查询学生的ID：");
        String id = input();

//        System.out.println(id);

        try {
            Student student = this.studentService.getStudent(id);
            if(student == null) {
                System.out.println("无此ID = " + id + "学生信息");
            } else {
                System.out.println(student.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doQueries() {

        try {
            List<Student> studentList = this.studentService.getStudents();
            if(studentList != null) {
                for(Student student : studentList) {
                    System.out.println(student.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doRemoves() {
        System.out.println("请输入要删除的学生的id值，多个以\",\"号隔开，最后一个不要逗号，回车结束");
        String ids = input();

        try {
            this.studentService.removeStudents(ids);
            System.out.println("批量删除成功。");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void doNewStudentAndLog() {
        System.out.println("new");
        System.out.println("请输入新增学生的名字：");
        String name = input();
        System.out.println("请输入新增学生的年龄：");
        String age = input();

        try {
            this.studentService.newStudentAndLog(name, age);
            System.out.println("新增学生信息成功。");
        } catch (ServiceException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("新增学生信息失败。");
            System.err.println("程序出错，请稍后再试|联系管理员。");
        }
    }

    private void doQueryByName() {
        System.out.println("请输入你要查询学生的名字：");
        String name = input();


        try {
            Student student = this.studentService.getStudentByName(name);
            if(student == null) {
                System.out.println("无此name = " + name + "学生信息");
            } else {
                System.out.println(student.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {

        System.out.println("=============欢迎来到学生系统================");

        exit : while(true) {
            for (String menu : menus) {
                System.out.println(menu);
            }

            System.out.println("请选择");

            String input = input();

            switch (input) {
                case "1":
                    doNew();
                    break;
                case "2":
                    doModify();
                    break;
                case "3":
                    doRemove();
                    break;
                case "4":
                    doQuery();
                    break;
                case "5":
                    doQueries();
                    break;
                case "6":
                    doRemoves();
                    break;
                case "7":
                    doNewStudentAndLog();
                    break;
                case "8":
                    doQueryByName();
                    break;
                default:
                    System.out.println("=============程序结束 END================");
                    break exit;
            }

        }




    }
}
