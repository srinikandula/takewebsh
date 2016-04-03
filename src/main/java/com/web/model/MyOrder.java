package com.web.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by njonnala on 4/1/2016.
 */
@Entity(name = "MyOrder")
public class MyOrder {

    @Id
    @SequenceGenerator(name="ORDER_SEQ", sequenceName="ORDER_SEQ", allocationSize=1) // sequenceName represents the name actual sequence in the database // name gives a name for the sequence so that it can be referneced by @generated value annotation
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="ORDER_SEQ")
    @Column(name = "orderId")

    @Getter
    @Setter
    private int orderId;

    @Getter
    @Setter
    private String orderName;

    @Getter
    @Setter
    private String orderType;

    @Getter
    @Setter
    private int orderPrice;

    @Getter
    @Setter
    private int orderQuantity;

    @Getter
    @Setter
    private int orderAmount;

}

