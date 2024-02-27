package com.joaquin.entities;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "people")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class Person implements Serializable {

    private static final long serialVersionUID = -1054285799144768494L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String age;
    private String createAt;
}
