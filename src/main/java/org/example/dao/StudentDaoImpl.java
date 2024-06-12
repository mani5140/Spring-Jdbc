package org.example.dao;

import org.example.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{

    @Autowired // this is for @Component autowiring
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Student student) {
        String query = "insert into student(id,name,city) values(?,?,?)";
        int result = jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return result;
    }

    @Override
    public int update(Student student) {
        String query = "update student set name=?, city=? where id=?";
        int result = jdbcTemplate.update(query, student.getName(),student.getCity(),student.getId());
        return result;
    }

    @Override
    public int delete(int studentId) {
        return 0;
    }

    @Override
    public Student getStudent(int studentId) {
        String query = "select * from student where id=?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        String query = "select * from student";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        List<Student> students = this.jdbcTemplate.query(query, rowMapper);
        return students;
    }
}
