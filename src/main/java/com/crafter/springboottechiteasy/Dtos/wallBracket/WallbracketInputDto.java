package com.crafter.springboottechiteasy.Dtos.wallBracket;

import com.crafter.springboottechiteasy.models.Television;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class WallbracketInputDto {
    private String name;
    private String size;
    private Double price;
    private Integer originalStock;
    private List<Television> televisions = new ArrayList<>();
}
