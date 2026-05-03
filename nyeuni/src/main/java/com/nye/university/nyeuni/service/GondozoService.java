package com.nye.university.nyeuni.service;

import java.util.List;
import java.util.Optional;

import com.nye.university.nyeuni.dto.gondozo.GondozoRequestDto;
import com.nye.university.nyeuni.dto.gondozo.GondozoResponseDto;
import com.nye.university.nyeuni.entity.Gondozo;
import com.nye.university.nyeuni.exception.ResourceNotFoundException;
import com.nye.university.nyeuni.repository.GondozoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GondozoService {

    @Autowired
    private GondozoRepository gondozoRepository;

    public GondozoResponseDto createGondozo(GondozoRequestDto gondozoRequestDto) {
        Gondozo gondozo = Gondozo.builder()
                .terulet(gondozoRequestDto.getTerulet())
                .gondozonev(gondozoRequestDto.getGondozonev())
                .build();
        Gondozo savedGondozo = gondozoRepository.save(gondozo);
        return mapToDto(savedGondozo);
    }

    public List<GondozoResponseDto> getAllGondozos() {
        return gondozoRepository.findAll()
            .stream()
            .map(this::mapToDto)
            .toList();
    }

    public GondozoResponseDto getGondozoById(Long id) {
        Optional<Gondozo> gondozoOptional = gondozoRepository.findById(id);
        Gondozo gondozo = gondozoOptional
                .orElseThrow(
                        () -> new ResourceNotFoundException("Nincs ilyen gondozo id: " + id)
                );
        return mapToDto(gondozo);
    }



    public GondozoResponseDto updateGondozo(Long id, GondozoRequestDto requestDto) {
        Gondozo gondozo = gondozoRepository.findById(id)
                .orElseThrow(
                    () -> new ResourceNotFoundException("Nincs ilyen gondozo id: " + id)
                );

        gondozo.setTerulet(requestDto.getTerulet());
        gondozo.setGondozonev(requestDto.getGondozonev());

        Gondozo updatedGondozo = gondozoRepository.save(gondozo);
        return mapToDto(updatedGondozo);
    }

    public void deleteGondozo(Long id) {
        gondozoRepository.deleteById(id);
    }

    private GondozoResponseDto mapToDto(Gondozo gondozo) {
        return GondozoResponseDto.builder()
                .id(gondozo.getId())
                .terulet(gondozo.getTerulet())
                .gondozonev(gondozo.getGondozonev())
                .build();
    }

}


