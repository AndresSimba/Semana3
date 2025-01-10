package com.pgmq.msa.booting.microservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name="booking")
public class Booking {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastName ;
    private String email ;


/*    Public booking(){

        super();
    }
    public Booking(int id, String name, String lastName, String email) {
        super();
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }*/
}
