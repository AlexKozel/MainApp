package com.example.MainApp.dao;


import com.example.MainApp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    EmployeeDao(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Employee> findAll() {
        return jdbcTemplate.query("select * from employee", new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    public Employee findById(int id) {
        return jdbcTemplate.queryForObject("select * from employee where id=?",
                new Object[]{id}, new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from employee where id=?",
                id);
    }

    public int save(Employee employee) {
        return jdbcTemplate.update("insert into EMPLOYEE (FIRST_NAME, LAST_NAME, BIRTH_DATE, SALARY) " +
                        "values ( ?, ?, ?, ? )",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getBirthDate(),
                employee.getSalary());
    }

    public int update(Employee employee) {
        return jdbcTemplate.update("update EMPLOYEE set FIRST_NAME =?," +
                        "  LAST_NAME =?," +
                        "  BIRTH_DATE =?," +
                        "  SALARY =? where id=? ",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getBirthDate(),
                employee.getSalary());
    }
}
