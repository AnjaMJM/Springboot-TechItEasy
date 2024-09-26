package com.crafter.springboottechiteasy.services;

import com.crafter.springboottechiteasy.Dtos.remote.RemoteInputDto;
import com.crafter.springboottechiteasy.Dtos.remote.RemoteOutputDto;
import com.crafter.springboottechiteasy.exceptions.IndexOutOfBoundsException;
import com.crafter.springboottechiteasy.exceptions.RecordNotFoundException;
import com.crafter.springboottechiteasy.exceptions.RequirementsNotMetException;
import com.crafter.springboottechiteasy.models.Remote;
import com.crafter.springboottechiteasy.repositories.RemoteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.crafter.springboottechiteasy.mappers.RemoteMapper.*;

@Service
public class RemoteService {

    private final RemoteRepository remoteRepository;

    public RemoteService(RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    public List<RemoteOutputDto> getAllRemotes() {
        List<Remote> remotes = remoteRepository.findAll();
        List<RemoteOutputDto> dto = new ArrayList<>();

        for (Remote remote: remotes) {
            dto.add(RemoteToOutput(remote));
        }
        return dto;
    }


    public RemoteOutputDto getOneRemote(Long id) {
        Remote Remote = remoteRepository.findById(id)
                .orElseThrow(() -> new IndexOutOfBoundsException("Remotecontroller not found"));
        return RemoteToOutput(Remote);
    }

    public RemoteOutputDto createRemote(RemoteInputDto newRemote) {
        if (newRemote.getName().length() < 20) {
            Remote r =remoteRepository.save(InputToRemote(newRemote));
            return RemoteToOutput(r);
        } else {
            throw new RequirementsNotMetException("The name is too long. There is a max of 20 characters");
        }
    }

    public RemoteOutputDto updateRemote(Long id, RemoteInputDto updatedRemote) {
        Optional<Remote> television = remoteRepository.findById(id);
        if (television.isPresent()) {
            Remote r = remoteRepository.save(InputToRemote(updatedRemote));
            return RemoteToOutput(r);
        } else {
            throw new RecordNotFoundException();
        }
    }

    public void deleteRemote(Long id) {
        Optional<Remote> television = remoteRepository.findById(id);
        if (television.isPresent()) {
            remoteRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException();
        }
    }
}
