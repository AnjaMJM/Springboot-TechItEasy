package com.crafter.springboottechiteasy.Dtos.remote;

import com.crafter.springboottechiteasy.models.Television;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoteInputDto {

    private String name;
    private String brand;
    private String compatibleWith;
    private String batteryType;
    private Double price;
    private Integer originalStock;
    private Television television;
}
