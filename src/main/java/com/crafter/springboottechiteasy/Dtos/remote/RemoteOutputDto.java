package com.crafter.springboottechiteasy.Dtos.remote;

import com.crafter.springboottechiteasy.Dtos.television.TelevisionOutputDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoteOutputDto {
    private Long id;
    private String name;
    private String brand;
    private String compatibleWith;
    private String batteryType;
    private Double price;
    private Integer originalStock;
    private Integer sold;
    private Long televisionId;
}
