package com.crafter.springboottechiteasy.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "remotes")
public class Remote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private String compatibleWith;
    private String batteryType;
    private Double price;
    private Integer originalStock;
    private Integer sold;
    @OneToOne(mappedBy = "remote", cascade = CascadeType.ALL)
    private Television television;
}
