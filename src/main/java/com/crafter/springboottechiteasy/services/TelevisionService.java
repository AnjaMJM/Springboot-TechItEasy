package com.crafter.springboottechiteasy.services;

import com.crafter.springboottechiteasy.Dtos.television.TelevisionInputDto;
import com.crafter.springboottechiteasy.Dtos.television.TelevisionOutputDto;
import com.crafter.springboottechiteasy.Dtos.television.TelevisionSalesDto;
import com.crafter.springboottechiteasy.exceptions.IndexOutOfBoundsException;
import com.crafter.springboottechiteasy.exceptions.RecordNotFoundException;
import com.crafter.springboottechiteasy.exceptions.RequirementsNotMetException;
import com.crafter.springboottechiteasy.models.Remote;
import com.crafter.springboottechiteasy.models.Television;
import com.crafter.springboottechiteasy.repositories.RemoteRepository;
import com.crafter.springboottechiteasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.crafter.springboottechiteasy.mappers.TelevisionMapper.*;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;
    private final RemoteRepository remoteRepository;

    public TelevisionService(TelevisionRepository televisionRepository, RemoteRepository remoteRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteRepository = remoteRepository;
    }



    public List<TelevisionOutputDto> getAllTelevisions() {
        List<Television> tvs = televisionRepository.findAll();
        List<TelevisionOutputDto> dto = new ArrayList<>();

        for (Television tv: tvs) {
            dto.add(TelevisionToOutput(tv));
        }
        return dto;
    }


    public TelevisionOutputDto getOneTelevision(Long id) {
        Television television = televisionRepository.findById(id)
                .orElseThrow(() -> new IndexOutOfBoundsException("Tv not found"));
            return TelevisionToOutput(television);
    }

    public TelevisionSalesDto getSalesInfoTelevision(Long id) {
        Television tv = televisionRepository.findById(id)
                .orElseThrow(() -> new IndexOutOfBoundsException("Tv not found"));
        return TelevisionToSales(tv);
    }

    public TelevisionOutputDto createTelevision(TelevisionInputDto newTv) {
        if (newTv.getName().length() < 20) {
            Television t =televisionRepository.save(InputToTelevision(newTv));
            return TelevisionToOutput(t);
        } else {
            throw new RequirementsNotMetException("The name is too long. There is a max of 20 characters");
        }
    }

    public TelevisionOutputDto updateTelevision(Long id, TelevisionInputDto updatedTv) {
        Optional<Television> television = televisionRepository.findById(id);
        if (television.isPresent()) {
            Television t = televisionRepository.save(InputToTelevision(updatedTv));
            return TelevisionToOutput(t);
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

    public void assignRemoteToTelevision(Long tvId, Long remoteId){
        Optional<Television> optionalTelevision = televisionRepository.findById(tvId);
        Optional<Remote> optionalRemote = remoteRepository.findById(remoteId);

        if(optionalTelevision.isPresent() && optionalRemote.isPresent()) {
            Television television = optionalTelevision.get();
            Remote remote = optionalRemote.get();

            television.setRemote(remote);
            televisionRepository.save(television);
        } else {
            throw new RecordNotFoundException();
        }
    }
}
