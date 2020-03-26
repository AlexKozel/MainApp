package com.example.MainApp;

import com.example.MainApp.dao.EmployeeDao;
import com.example.MainApp.entity.Employee;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
@Rollback
public class DaoTest {

    private Employee employee = new Employee(3,"Test", "Testovich", new Date(), 1000);


    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void findByIdTest() {
        Assert.assertNotNull(employeeDao.findById(2));

    }

    @Test
    public void findAllTest() {
        List list = new ArrayList();
        int before = list.size();
        list = employeeDao.findAll();
        int after = list.size();
        Assert.assertTrue(before < after);
    }

    @Test
    public void deleteByIdTest() {
        List list = employeeDao.findAll();
        int before = list.size();
        employeeDao.deleteById(1);
        list = employeeDao.findAll();
        int after = list.size();
        Assert.assertTrue(before > after);
    }

    @Test
    public void saveTest() {
        List list = employeeDao.findAll();
        int before = list.size();
        employeeDao.save(employee);
        list = employeeDao.findAll();
        int after = list.size();
        Assert.assertTrue(before < after);
    }


    @Test
    public void updateTest() {
        Employee oldEmployee = employeeDao.findById(3);
        employeeDao.update(employee);
        Employee newEmployee = employeeDao.findById(3);
        Assert.assertNotEquals(oldEmployee.getFirstName(), newEmployee.getFirstName());
        System.out.println(oldEmployee.getFirstName() + newEmployee.getFirstName());
        Assert.assertEquals(newEmployee.getFirstName(), "Test");
        System.out.println("s");
    }

}
