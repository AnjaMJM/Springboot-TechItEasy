package com.crafter.springboottechiteasy.mappers;

import com.crafter.springboottechiteasy.Dtos.ciModule.CiModuleInputDto;
import com.crafter.springboottechiteasy.Dtos.ciModule.CiModuleOutputDto;
import com.crafter.springboottechiteasy.models.CiModule;

public class CiModuleMapper {

    public static CiModule InputToModule (CiModuleInputDto dto) {
        CiModule module = new CiModule();
        module.setName(dto.getName());
        module.setType(dto.getType());
        module.setPrice(dto.getPrice());
        module.setTelevision(dto.getTelevision());
        return module;
    }

    public static CiModuleOutputDto ModuleToDto (CiModule module) {
        CiModuleOutputDto dto = new CiModuleOutputDto();
        dto.setId(module.getId());
        dto.setName(module.getName());
        dto.setType(module.getType());
        dto.setPrice(module.getPrice());
        dto.setOriginalStock(module.getOriginalStock());
        dto.setSold(module.getSold());
        dto.setTelevision(module.getTelevision());
        return dto;
    }
}
