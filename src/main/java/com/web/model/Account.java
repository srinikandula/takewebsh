package com.web.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

}
