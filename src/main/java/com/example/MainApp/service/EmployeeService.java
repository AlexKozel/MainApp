package com.example.MainApp.service;

import com.example.MainApp.dao.EmployeeDao;
import com.example.MainApp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements CrudService{

   private EmployeeDao dao;

   EmployeeService(@Autowired EmployeeDao dao){
       this.dao = dao;
   }


    @Override
    public Employee findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return dao.findAll();
    }

    @Override
    public int update(Employee employee) {
        return dao.update(employee);
    }

    @Override
    public int save(Employee employee) {
        return dao.save(employee);
    }

    @Override
    public int deleteById(int id) {
        return dao.deleteById(id);
    }
}
