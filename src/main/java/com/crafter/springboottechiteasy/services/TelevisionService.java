package com.crafter.springboottechiteasy.services;

import com.crafter.springboottechiteasy.exceptions.RecordNotFoundException;
import com.crafter.springboottechiteasy.exceptions.RequirementsNotMetException;
import com.crafter.springboottechiteasy.models.Television;
import com.crafter.springboottechiteasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<Television> getAllTelevisions() {
        return televisionRepository.findAll();
    }

    public Television getOneTelevision(Long id) {
            Optional<Television> television = televisionRepository.findById(id);
            if (television.isPresent()){
                return television.get();
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

    public Television createTelevision(Television tv) {
        if (tv.getName().length() < 20) {
            return televisionRepository.save(tv);
        } else {
            throw new RequirementsNotMetException("The name is too long. There is a max of 20 characters");
        }
    }

    public void updateTelevision(Long id, Television tv) {
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
