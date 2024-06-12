package org.example;

import org.example.config.JdbcConfig;
import org.example.dao.StudentDao;
import org.example.dao.StudentDaoImpl;
import org.example.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("config.xml");     //this is for xml configuration

        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

//        Student std = new Student();
//        std.setId(2);
//        std.setName("hari");
//        std.setCity("sambalpur");
//        System.out.println(studentDao.insert(std));
//        System.out.println(studentDao.update(std));
//        Student student = studentDao.getStudent(1);

        List<Student> students = studentDao.getAllStudent();
        for(Student s:students){
            System.out.println(s);
        }
    }
}













