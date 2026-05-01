package com.nye.university.nyeuni.controller;


import com.nye.university.nyeuni.dto.gondozo.GondozoRequestDto;
import com.nye.university.nyeuni.dto.gondozo.GondozoResponseDto;
import com.nye.university.nyeuni.service.GondozoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//ezt a gondozo controllert innentől kezdve a http://localhost:8080/api/gondozo
@RequestMapping("/api/gondozo")
@RequiredArgsConstructor
public class GondozoController {
//ezt a gondozo controllert innentől kezdve a http://localhost:8080/api/gondozo

    private final GondozoService gondozoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GondozoResponseDto createGondozo(@RequestBody GondozoRequestDto requestDto) {
        return gondozoService.createGondozo(requestDto);
    }


    @GetMapping
    public List<GondozoResponseDto> getAllGondozos() {
        return gondozoService.getAllGondozos();
    }

    @GetMapping("/{id}")
    public GondozoResponseDto getGondozoById(@PathVariable Long id) {
        return gondozoService.getGondozoById(id);
    }

    @PutMapping("/{id}")
    public GondozoResponseDto updateGondozo(@PathVariable Long id,
                                            @RequestBody GondozoRequestDto requestDto) {
        return gondozoService.updateGondozo(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGondozo(@PathVariable Long id) {
        gondozoService.deleteGondozo(id);
    }
}





