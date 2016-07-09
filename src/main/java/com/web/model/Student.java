package com.web.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by devendra on 4/2/2016.
 */
@Entity(name = "Student")
public class Student implements Serializable{
    @Id
    @SequenceGenerator(name="STUDENT_SEQ", sequenceName="STUDENT_SEQ", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="STUDENT_SEQ")
    @Column(name = "studentId")

    @Getter
    @Setter
    private int studentId;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;
}
