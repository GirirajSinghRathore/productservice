package com.giriraj.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = jakarta.persistence.InheritanceType.JOINED)
public class Player {
    @Id
    private long id;
    private String name;
    private int age;
}
