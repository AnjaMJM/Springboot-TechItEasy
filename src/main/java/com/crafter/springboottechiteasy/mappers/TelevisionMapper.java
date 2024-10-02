package com.crafter.springboottechiteasy.mappers;

import com.crafter.springboottechiteasy.Dtos.television.TelevisionInputDto;
import com.crafter.springboottechiteasy.Dtos.television.TelevisionOutputDto;
import com.crafter.springboottechiteasy.Dtos.television.TelevisionSalesDto;
import com.crafter.springboottechiteasy.models.Television;

import java.util.ArrayList;
import java.util.List;

public class TelevisionMapper {
    public static TelevisionOutputDto TelevisionToOutput(Television television) {
        TelevisionOutputDto dto = new TelevisionOutputDto();
        dto.setId(television.getId());
        dto.setType(television.getType());
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getSmartTv());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbilight(television.getAmbilight());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());
        if (television.getRemote() != null){
            dto.setRemote(RemoteMapper.RemoteToOutput(television.getRemote()));
        }
        if (television.getWallBrackets() != null) {
            dto.setWallBrackets(WallBracketMapper.ListWallBracketsToDto(television.getWallBrackets()));
        }
        if (television.getModule() != null) {
            dto.setModule(CiModuleMapper.ModuleToOutput(television.getModule()));
        }
        return dto;
    }

    public static Television InputToTelevision(TelevisionInputDto dto) {
        Television television = new Television();
        television.setType(dto.getType());
        television.setBrand(dto.getBrand());
        television.setName(dto.getName());
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        television.setScreenType(dto.getScreenType());
        television.setScreenQuality(dto.getScreenQuality());
        television.setSmartTv(dto.getSmartTv());
        television.setWifi(dto.getWifi());
        television.setVoiceControl(dto.getVoiceControl());
        television.setHdr(dto.getHdr());
        television.setBluetooth(dto.getBluetooth());
        television.setAmbilight(dto.getAmbilight());
        television.setOriginalStock(dto.getOriginalStock());
        return television;
    }

    public static List<TelevisionOutputDto> ListTelevisionToDto(List<Television> televisions) {
        List<TelevisionOutputDto> dtos = new ArrayList<>();
        for (Television television : televisions) {
            TelevisionOutputDto dto = TelevisionToOutput(television);
            dtos.add(dto);}
        return dtos;

    }

    public static TelevisionSalesDto TelevisionToSales(Television television) {
        TelevisionSalesDto dto = new TelevisionSalesDto();
        dto.setId(television.getId());
        dto.setType(television.getType());
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());
        return dto;
    }
}

