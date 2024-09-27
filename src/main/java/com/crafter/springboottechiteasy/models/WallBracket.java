package com.crafter.springboottechiteasy.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Wall_brackets")
@Getter
@Setter
public class WallBracket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String size;
    private Double price;
    private Integer originalStock;
    private Integer sold;
    @ManyToMany(mappedBy = "wallBrackets")
    private List<Television> televisions = new ArrayList<>();


}
