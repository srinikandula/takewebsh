package com.web.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Employee")
public class Employee implements Serializable {

    @Id
    @SequenceGenerator(name="EMPLOYEE_SEQ", sequenceName="EMPLOYEE_SEQ", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="EMPLOYEE_SEQ")
    @Column(name = "employeeId")

    @Getter
    @Setter
    private int employeeId;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    private int salary;
    //private String salary;





}
