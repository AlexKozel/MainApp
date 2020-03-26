package com.example.MainApp;

import com.example.MainApp.dao.EmployeeDao;
import com.example.MainApp.entity.Employee;
import com.example.MainApp.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ServiceTest {

    Employee employee = new Employee(1,"Test", "Testovich", new Date(), 1000);

    EmployeeDao daoMock = mock(EmployeeDao.class);
    EmployeeService service = new EmployeeService(daoMock);

    @Test
    public void getByIdTest(){
        when(daoMock.findById(1)).thenReturn(employee);
        Employee getEmployee = service.findById(1);
        assertEquals(getEmployee, employee);

    }

    @Test
    public void getAllTest(){
        List<Employee> list = new ArrayList<>();
        list.add(employee);
        when(daoMock.findAll()).thenReturn(list);
        assertEquals(list, service.findAll());

    }

    @Test
    public void updateTest(){
        when(daoMock.update(employee)).thenReturn(1);
        assertEquals(1, daoMock.update(employee));
    }

    @Test
    public void createTest(){
        when(daoMock.save(employee)).thenReturn(1);
        assertEquals(1, daoMock.save(employee));
    }

    @Test
    public void deleteTest(){
        when(daoMock.deleteById(1)).thenReturn(1);
        assertEquals(1, daoMock.deleteById(1));
    }
}
