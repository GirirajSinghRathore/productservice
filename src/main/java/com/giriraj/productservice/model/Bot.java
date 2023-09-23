package com.giriraj.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@PrimaryKeyJoinColumn(name = "playerId")
public class Bot extends Player{
    private int rank;
}
