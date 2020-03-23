package com.example.MainApp.service;

import com.example.MainApp.entity.Employee;

import java.util.List;

public interface CrudService {

    public Employee findById(int id);

    public List<Employee> findAll();

    public int update(Employee employee);

    public int save(Employee employee);

    public int deleteById(int id);

}
