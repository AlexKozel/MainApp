package com.example.MainApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @JsonIgnore
    private int id;
    private String firstName;

    private String lastName;
    @Past
    private Date birthDate;
    @Min(value = 10)
    private int salary;

}
