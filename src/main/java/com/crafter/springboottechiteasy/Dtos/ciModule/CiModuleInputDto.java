package com.crafter.springboottechiteasy.Dtos.ciModule;

import com.crafter.springboottechiteasy.models.Television;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CiModuleInputDto {
    private String name;
    private String type;
    private Double price;
    private Television television;
}
