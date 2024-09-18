package com.crafter.springboottechiteasy.services;

import com.crafter.springboottechiteasy.Dtos.TelevisionDto;
import com.crafter.springboottechiteasy.exceptions.IndexOutOfBoundsException;
import com.crafter.springboottechiteasy.exceptions.RecordNotFoundException;
import com.crafter.springboottechiteasy.exceptions.RequirementsNotMetException;
import com.crafter.springboottechiteasy.models.Television;
import com.crafter.springboottechiteasy.repositories.TelevisionRepository;
import io.micrometer.observation.ObservationFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.crafter.springboottechiteasy.mappers.TelevisionMapper.televisionToDto;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<TelevisionDto> getAllTelevisions() {
        List<Television> tvs = televisionRepository.findAll();
        List<TelevisionDto> dto = new ArrayList<>();

        for (Television tv: tvs) {
            dto.add(televisionToDto(tv));
        }
        return dto;
    }


    public TelevisionDto getOneTelevision(Long id) {
        Television television = televisionRepository.findById(id)
                .orElseThrow(() -> new IndexOutOfBoundsException("Tv not found"));
            return televisionToDto(television);
    }

    public TelevisionDto createTelevision(TelevisionDto newTv) {
        if (newTv.getName().length() < 20) {
            return televisionRepository.save(newTv);
        } else {
            throw new RequirementsNotMetException("The name is too long. There is a max of 20 characters");
        }
    }

    public void updateTelevision(Long id, TelevisionDto tv) {
        Optional<Television> television = televisionRepository.findById(id);
        if (television.isPresent()) {
            tv.setId(id);
            televisionRepository.save(tv);
        } else {
            throw new RecordNotFoundException();
        }
    }

    public void deleteTelevision(Long id) {
        Optional<Television> television = televisionRepository.findById(id);
        if (television.isPresent()) {
            televisionRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException();
        }
    }
}
