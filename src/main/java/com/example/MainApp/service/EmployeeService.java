package com.example.MainApp.service;

import com.example.MainApp.dao.EmployeeDao;
import com.example.MainApp.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService implements CrudService{

    Logger log = LoggerFactory.getLogger(EmployeeService.class);
//
//    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//    Validator validator = factory.getValidator();

   private EmployeeDao dao;

   public EmployeeService(@Autowired EmployeeDao dao){
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
//        Set<ConstraintViolation<Employee>> violations = validator.validate(employee);
//        for(ConstraintViolation<Employee> violation : violations){
//        log.error(violation.getMessage());
//        }
//       Employee employee1 = employee;

        return dao.save(employee);
    }

    @Override
    public int deleteById(int id) {
        return dao.deleteById(id);
    }
}
