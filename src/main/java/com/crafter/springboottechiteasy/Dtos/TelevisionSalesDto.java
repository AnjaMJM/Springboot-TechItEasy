package com.crafter.springboottechiteasy.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelevisionSalesDto {
    private Long id;
    private String type;
    private String brand;
    private String name;
    private Double price;
    private Integer originalStock;
    private Integer sold;
}
