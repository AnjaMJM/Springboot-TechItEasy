package com.crafter.springboottechiteasy.Dtos.ciModule;

import com.crafter.springboottechiteasy.Dtos.television.TelevisionOutputDto;
import com.crafter.springboottechiteasy.models.Television;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CiModuleOutputDto {
    private Long id;
    private String name;
    private String type;
    private Double price;
    private Integer originalStock;
    private Integer sold;
    private List<Long> televisionIdList;
}
