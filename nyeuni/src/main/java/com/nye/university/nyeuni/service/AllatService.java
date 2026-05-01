package com.nye.university.nyeuni.service;


import com.nye.university.nyeuni.dto.allat.AllatRequestDto;
import com.nye.university.nyeuni.dto.allat.AllatResponseDto;
import com.nye.university.nyeuni.dto.gondozo.GondozoRequestDto;
import com.nye.university.nyeuni.dto.gondozo.GondozoResponseDto;
import com.nye.university.nyeuni.entity.Allat;
import com.nye.university.nyeuni.entity.Gondozo;
import com.nye.university.nyeuni.exception.ResourceNotFoundException;
import com.nye.university.nyeuni.repository.AllatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllatService {

    @Autowired
    private AllatRepository allatRepository;

    public AllatResponseDto createAllat (AllatRequestDto allatRequestDto) {
        Allat allat = Allat.builder()
                .nev(allatRequestDto.getNev())
                .kor(allatRequestDto.getKor())
                .build();
        Allat savedAllat =allatRepository.save(allat);
        return mapToDto(savedAllat);
    }

    public List<AllatResponseDto> getAllAllats () {
        return allatRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    public AllatResponseDto getAllatById (Long id) {
        Optional<Allat> allatOptional = allatRepository.findById(id);
        Allat allat = allatOptional
                .orElseThrow(
                        () -> new ResourceNotFoundException("Nincs ilyen allat id: "+ id )
                );
        return mapToDto(allat);
    }

    public AllatResponseDto updateAllat(Long id, AllatRequestDto requestDto) {
        Allat allat = allatRepository.findById(id)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("Nincs ilyen allat id: " + id)
                );

        allat.setNev(requestDto.getNev());
        allat.setKor(requestDto.getKor());

        Allat updatedAllat = allatRepository.save(allat);
        return mapToDto(updatedAllat);
    }

    public void deleteAllat (Long id) {
        allatRepository.deleteById(id);
    }

    private AllatResponseDto mapToDto(Allat allat) {
        return AllatResponseDto.builder()
                .id(allat.getId())
                .nev(allat.getNev())
                .kor(allat.getKor())
                .build();
    }
}
