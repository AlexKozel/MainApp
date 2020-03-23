package com.example.MainApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int salary;

}
