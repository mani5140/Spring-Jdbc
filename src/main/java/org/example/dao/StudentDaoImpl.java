package org.example.dao;

import org.example.entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoImpl implements StudentDao{
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
}