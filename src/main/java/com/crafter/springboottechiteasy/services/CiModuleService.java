package com.crafter.springboottechiteasy.services;

import com.crafter.springboottechiteasy.Dtos.ciModule.CiModuleInputDto;
import com.crafter.springboottechiteasy.Dtos.ciModule.CiModuleOutputDto;
import com.crafter.springboottechiteasy.Dtos.television.TelevisionSalesDto;
import com.crafter.springboottechiteasy.exceptions.IndexOutOfBoundsException;
import com.crafter.springboottechiteasy.exceptions.RecordNotFoundException;
import com.crafter.springboottechiteasy.exceptions.RequirementsNotMetException;
import com.crafter.springboottechiteasy.models.CiModule;
import com.crafter.springboottechiteasy.repositories.CiModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.crafter.springboottechiteasy.mappers.CiModuleMapper.InputToModule;
import static com.crafter.springboottechiteasy.mappers.CiModuleMapper.ModuleToOutput;

@Service
public class CiModuleService {

    private final CiModuleRepository ciModuleRepository;

    public CiModuleService(CiModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }

    public List<CiModuleOutputDto> getAllCiModules() {
        List<CiModule> modules = ciModuleRepository.findAll();
        List<CiModuleOutputDto> dto = new ArrayList<>();

        for (CiModule module: modules) {
            dto.add(ModuleToOutput(module));
        }
        return dto;
    }

    public CiModuleOutputDto getOneCiModule(Long id) {
        CiModule module = ciModuleRepository.findById(id)
                .orElseThrow(() -> new IndexOutOfBoundsException("CiModule not found"));
        return ModuleToOutput(module);
    }

    public CiModuleOutputDto createCiModule(CiModuleInputDto newModule) {
        if (newModule.getName().length() < 20) {
            CiModule module =ciModuleRepository.save(InputToModule(newModule));
            return ModuleToOutput(module);
        } else {
            throw new RequirementsNotMetException("The name is too long. There is a max of 20 characters");
        }
    }

    public CiModuleOutputDto updateCiModule(Long id, CiModuleInputDto updatedModule) {
        Optional<CiModule> module = ciModuleRepository.findById(id);
        if (module.isPresent()) {
            CiModule m = ciModuleRepository.save(InputToModule(updatedModule));
            return ModuleToOutput(m);
        } else {
            throw new RecordNotFoundException();
        }
    }

    public void deleteCiModule(Long id) {
        Optional<CiModule> module = ciModuleRepository.findById(id);
        if (module.isPresent()) {
            ciModuleRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException();
        }
    }

}
