package com.crafter.springboottechiteasy.mappers;

import com.crafter.springboottechiteasy.Dtos.remote.RemoteInputDto;
import com.crafter.springboottechiteasy.Dtos.remote.RemoteOutputDto;
import com.crafter.springboottechiteasy.models.Remote;

public class RemoteMapper {

    public static Remote InputToRemote(RemoteInputDto dto){
        Remote remote = new Remote();
        remote.setName(dto.getName());
        remote.setBrand(dto.getBrand());
        remote.setCompatibleWith(dto.getCompatibleWith());
        remote.setBatteryType(dto.getBatteryType());
        remote.setPrice(dto.getPrice());
        remote.setOriginalStock(dto.getOriginalStock());
        remote.setTelevision(dto.getTelevision());
        return remote;
    }

    public static RemoteOutputDto RemoteToOutput(Remote remote){
        RemoteOutputDto dto = new RemoteOutputDto();
        dto.setId(remote.getId());
        dto.setName(remote.getName());
        dto.setBrand(remote.getBrand());
        dto.setCompatibleWith(remote.getCompatibleWith());
        dto.setBatteryType(remote.getBatteryType());
        dto.setPrice(remote.getPrice());
        dto.setOriginalStock(remote.getOriginalStock());
        dto.setSold(remote.getSold());
        dto.setTelevision(remote.getTelevision());
        return dto;
    }
}
