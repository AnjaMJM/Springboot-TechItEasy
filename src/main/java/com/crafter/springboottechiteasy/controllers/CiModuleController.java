package com.crafter.springboottechiteasy.controllers;

import com.crafter.springboottechiteasy.Dtos.ciModule.CiModuleInputDto;
import com.crafter.springboottechiteasy.Dtos.ciModule.CiModuleOutputDto;
import com.crafter.springboottechiteasy.services.CiModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cimodule")
public class CiModuleController {

    private final CiModuleService ciModuleService;

    public CiModuleController(CiModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }

    @GetMapping
    public ResponseEntity<List<CiModuleOutputDto>> getAllCiModules() {
        return ResponseEntity.ok(ciModuleService.getAllCiModules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CiModuleOutputDto> getOneCiModule(@PathVariable Long id) {
        return ResponseEntity.ok(ciModuleService.getOneCiModule(id));
    }

    @PostMapping()
    public ResponseEntity<CiModuleOutputDto> createNewCiModule(@RequestBody CiModuleInputDto module) {
        CiModuleOutputDto updatedModule = new CiModuleOutputDto();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(updatedModule.getId())
                .toUri();
        return ResponseEntity.created(location).body(ciModuleService.createCiModule(module));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CiModuleOutputDto> updateCiModule(@PathVariable Long id, @RequestBody CiModuleInputDto module) {
        CiModuleOutputDto updatedModule = ciModuleService.updateCiModule(id, module);
        return ResponseEntity.ok(updatedModule);
    }

//    @PutMapping("/televisions/{id}/remote/{remoteId}")
//    public void assignRemoteControllerToTelevision(@PathVariable("id") Long id,@PathVariable Long remoteId) {
//        ciModuleService.assignRemoteToTelevision(id, remoteId);
//    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCiModule(@PathVariable Long id) {
        ciModuleService.deleteCiModule(id);
        return ResponseEntity.noContent().build();
    }
}
