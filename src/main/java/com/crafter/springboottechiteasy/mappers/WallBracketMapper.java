package com.crafter.springboottechiteasy.mappers;

import com.crafter.springboottechiteasy.Dtos.television.TelevisionOutputDto;
import com.crafter.springboottechiteasy.Dtos.wallBracket.WallbracketInputDto;
import com.crafter.springboottechiteasy.Dtos.wallBracket.WallbracketOutputDto;
import com.crafter.springboottechiteasy.models.Television;
import com.crafter.springboottechiteasy.models.WallBracket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        if(bracket.getTelevisions() != null) {
//            List<Long> tvId = new ArrayList<>();
//            for (Television t : bracket.getTelevisions()){
//                tvId.add(t.getId());
//            } equals:
            dto.setTelevisionIdList(bracket.getTelevisions().stream().map(Television::getId).collect(Collectors.toList()));
        }
        return dto;
    }

    public static List<WallbracketOutputDto> ListWallBracketsToDto(List<WallBracket> wallBrackets) {
        List<WallbracketOutputDto> dtos = new ArrayList<>();
        for (WallBracket wallBracket : wallBrackets) {
            WallbracketOutputDto dto = WallBracketToOutput(wallBracket);
            dtos.add(dto);}
        return dtos;

    }
}
