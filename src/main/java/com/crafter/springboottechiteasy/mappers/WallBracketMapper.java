package com.crafter.springboottechiteasy.mappers;

import com.crafter.springboottechiteasy.Dtos.wallBracket.WallbracketInputDto;
import com.crafter.springboottechiteasy.Dtos.wallBracket.WallbracketOutputDto;
import com.crafter.springboottechiteasy.models.WallBracket;

public class WallBracketMapper {

    public static WallBracket InputToWallBracket(WallbracketInputDto dto) {
        WallBracket bracket = new WallBracket();
        bracket.setName(dto.getName());
        bracket.setSize(dto.getSize());
        bracket.setPrice(dto.getPrice());
        bracket.setOriginalStock(dto.getOriginalStock());
        bracket.setTelevisions(dto.getTelevisions());
        return bracket;
    }

    public static WallbracketOutputDto WallBracketToOutput(WallBracket bracket){
        WallbracketOutputDto dto = new WallbracketOutputDto();
        dto.setId(bracket.getId());
        dto.setName(bracket.getName());
        dto.setSize(bracket.getSize());
        dto.setPrice(bracket.getPrice());
        dto.setOriginalStock(bracket.getOriginalStock());
        dto.setSold(bracket.getSold());
        dto.setTelevisions(bracket.getTelevisions());
        return dto;
    }
}
