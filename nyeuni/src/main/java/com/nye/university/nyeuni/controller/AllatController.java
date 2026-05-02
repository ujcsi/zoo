package com.nye.university.nyeuni.controller;

import com.nye.university.nyeuni.dto.allat.AllatRequestDto;
import com.nye.university.nyeuni.dto.allat.AllatResponseDto;
import com.nye.university.nyeuni.dto.gondozo.GondozoRequestDto;
import com.nye.university.nyeuni.service.AllatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
//ezt az allat controllert innentől kezdve a http://localhost:8080/api/allat
@RequestMapping("/api/allat")
@RequiredArgsConstructor
public class AllatController {
    //ezt az allat controllert innentől kezdve a http://localhost:8080/api/allat

    private final AllatService allatService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AllatResponseDto createAllat(@RequestBody AllatRequestDto requestDto) {
        return allatService.createAllat(requestDto);
    }

    @GetMapping
    public List<AllatResponseDto> getAllAllats() {
        return allatService.getAllAllats();
    }

    @GetMapping("/{id}")
    public AllatResponseDto getAllatById(@PathVariable Long id) {
        return allatService.getAllatById(id);
    }

    @PutMapping("/{id}")
    public AllatResponseDto updateAllat(@PathVariable Long id,
                                            @RequestBody AllatRequestDto requestDto) {
        return allatService.updateAllat(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllat(@PathVariable Long id) {
        allatService.deleteAllat(id);
    }
}