package com.example.MainApp;

import com.example.MainApp.entity.Employee;
import com.example.MainApp.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CommandLineRun implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(CommandLineRun.class);

    @Autowired
    EmployeeService service;

    @Override
    public void run(String... args) throws Exception {

        Employee employee = new Employee(4,"John", "Snow", new Date(1990- 2 -10), 1000);

        Employee emp = service.findById(1);
        log.info("find employee by Id - {}", emp);

    }
}
