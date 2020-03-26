package com.example.MainApp.controller;

import com.example.MainApp.entity.Employee;
import org.springframework.stereotype.Component;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator {

    public static final int EMPLOYEE_NAME_MIN_SIZE = 2;
    public static final int EMPLOYEE_NAME_MAX_SIZE = 255;


    @Override
    public boolean supports(Class<?> aClass) {
        return Employee.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName.empty");
        Employee employee = (Employee) o;

        if (StringUtils.hasLength(employee.getFirstName())
                && (employee.getFirstName().length() > EMPLOYEE_NAME_MAX_SIZE
                || employee.getFirstName().length() < EMPLOYEE_NAME_MIN_SIZE)) {
            errors.reject("LastName have to be longer than 2 and shorter then 255");
        }
        if (StringUtils.hasLength(employee.getLastName())
                && (employee.getFirstName().length() > EMPLOYEE_NAME_MAX_SIZE
                || employee.getFirstName().length() < EMPLOYEE_NAME_MIN_SIZE)) {
            errors.reject( "LastName have to be longer than 2 and shorter then 255");
        }
    }
}
