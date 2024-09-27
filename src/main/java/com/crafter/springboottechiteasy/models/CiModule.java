package com.crafter.springboottechiteasy.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ci_modules")
public class CiModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private Double price;
    private Integer originalStock;
    private Integer sold;
    @OneToMany(mappedBy = "module")
    private List<Television> televisions = new ArrayList<>();

}
