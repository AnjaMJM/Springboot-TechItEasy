package com.crafter.springboottechiteasy.services;

import com.crafter.springboottechiteasy.Dtos.wallBracket.WallbracketInputDto;
import com.crafter.springboottechiteasy.Dtos.wallBracket.WallbracketOutputDto;
import com.crafter.springboottechiteasy.exceptions.IndexOutOfBoundsException;
import com.crafter.springboottechiteasy.exceptions.RecordNotFoundException;
import com.crafter.springboottechiteasy.exceptions.RequirementsNotMetException;
import com.crafter.springboottechiteasy.models.WallBracket;
import com.crafter.springboottechiteasy.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.crafter.springboottechiteasy.mappers.RemoteMapper.InputToRemote;
import static com.crafter.springboottechiteasy.mappers.WallBracketMapper.InputToWallBracket;
import static com.crafter.springboottechiteasy.mappers.WallBracketMapper.WallBracketToOutput;

@Service
public class WallBracketService {

    private final WallBracketRepository wallbracketRepository;

    public WallBracketService(WallBracketRepository wallbracketRepository) {
        this.wallbracketRepository = wallbracketRepository;
    }


    public List<WallbracketOutputDto> getAllWallBrackets() {
        List<WallBracket> brackets = wallbracketRepository.findAll();
        List<WallbracketOutputDto> dto = new ArrayList<>();

        for (WallBracket bracket: brackets) {
            dto.add(WallBracketToOutput(bracket));
        }
        return dto;
    }


    public WallbracketOutputDto getOneRemote(Long id) {
        WallBracket wallBracket = wallbracketRepository.findById(id)
                .orElseThrow(() -> new IndexOutOfBoundsException("WallBracket not found"));
        return WallBracketToOutput(wallBracket);
    }

    public WallbracketOutputDto createWallBracket(WallbracketInputDto newWallBracket) {
        if (newWallBracket.getName().length() < 20) {
            WallBracket r =wallbracketRepository.save(InputToWallBracket(newWallBracket));
            return WallBracketToOutput(r);
        } else {
            throw new RequirementsNotMetException("The name is too long. There is a max of 20 characters");
        }
    }

    public WallbracketOutputDto updateWallBracket(Long id, WallbracketInputDto updatedWallBracket) {
        Optional<WallBracket> television = wallbracketRepository.findById(id);
        if (television.isPresent()) {
            WallBracket wb = wallbracketRepository.save(InputToWallBracket(updatedWallBracket));
            return WallBracketToOutput(wb);
        } else {
            throw new RecordNotFoundException();
        }
    }

    public void deleteWallBracket(Long id) {
        Optional<WallBracket> television = wallbracketRepository.findById(id);
        if (television.isPresent()) {
            wallbracketRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException();
        }
    }
}
