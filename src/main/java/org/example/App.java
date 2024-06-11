package org.example;

import org.example.dao.StudentDao;
import org.example.dao.StudentDaoImpl;
import org.example.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("config.xml");
        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        Student std = new Student();
        std.setId(3);
        std.setName("surya");
        std.setCity("sambalpur");
        System.out.println(studentDao.insert(std));
    }
}













