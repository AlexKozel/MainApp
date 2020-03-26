package com.example.MainApp.controller;

import com.example.MainApp.entity.Employee;
import com.example.MainApp.service.EmployeeService;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@RestController
public class EmployeeController {

    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService service;
    private final EmployeeValidator validator;


    @GetMapping("/")
    public List<Employee> findAll(){
        logger.debug("Find all employees" );
        return service.findAll();
    }

    @GetMapping("/{id}")
            public Employee getEmployeeById(@PathVariable int id){
        logger.debug("Find employee by id {}", id);
        service.findById(id);
        return service.findById(id);
    }
    @PostMapping("/")
    public List<Employee> saveUser( @RequestBody Employee employee, BindingResult result){
        logger.debug("save Employee - {}", employee);
        validator.validate(employee, result);
        if(result.hasErrors()){
            throw new RuntimeException(result.getAllErrors().toString());
        }
        else {
        service.save(employee);
        return service.findAll();
    }}

    @PostMapping("/{id}")
            public Employee update(@PathVariable int id, @RequestBody Employee employee){
        logger.debug("update employee - {} with id {}", employee, id);
        employee.setId(id);
        service.update(employee);
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
            public List<Employee> deleteById(@PathVariable int id){
        logger.debug("delete employee with id {}", id);
        service.deleteById(id);
        return service.findAll();
    }


    EmployeeController(@Autowired EmployeeService service, @Autowired EmployeeValidator validator){
        this.service = service;
        this.validator = validator;
    };

}
