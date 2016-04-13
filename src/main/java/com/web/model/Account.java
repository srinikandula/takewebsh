package com.web.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by skandula on 3/30/16.
 */

@Entity(name = "Account")
public class Account implements Serializable {
    @Id
    @SequenceGenerator(name="ACCOUNT_SEQ", sequenceName="ACCOUNT_SEQ", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="ACCOUNT_SEQ")
    @Column(name = "id")

    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private long balance;

    //[{"id":101,"firstName":"John","lastName":"carter","balance":1000},
    // {"id":102,"firstName":"Joe","lastName":"Issace","balance":1000},
    // {"id":103,"firstName":"John","lastName":"carter","balance":1000}]
}
