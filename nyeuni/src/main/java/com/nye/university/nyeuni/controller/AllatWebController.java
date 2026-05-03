package com.nye.university.nyeuni.controller;

import com.nye.university.nyeuni.dto.allat.AllatRequestDto;
import com.nye.university.nyeuni.dto.allat.AllatResponseDto;
import com.nye.university.nyeuni.service.AllatService;
import com.nye.university.nyeuni.service.GondozoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/allatok")
@RequiredArgsConstructor
public class AllatWebController {

    private final AllatService allatService;
    private final GondozoService gondozoService;

    @GetMapping
    public String listAllatok(Model model) {
        model.addAttribute("allatok", allatService.getAllAllats());
        model.addAttribute("gondozok", gondozoService.getAllGondozos());
        model.addAttribute("ujAllat", new AllatRequestDto());  // űrlaphoz
        return "allatok";  // allatok.html a templates mappában
    }

    @PostMapping("/uj")
    public String createAllat(@ModelAttribute("ujAllat") AllatRequestDto requestDto) {
        allatService.createAllat(requestDto);
        return "redirect:/allatok";
    }

    @GetMapping("/szerkesztes/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        AllatResponseDto allat = allatService.getAllatById(id);

        AllatRequestDto requestDto = AllatRequestDto.builder()
                .nev(allat.getNev())
                .kor(allat.getKor())
                .gondozoId(allat.getGondozoId())
                .build();

        model.addAttribute("szerkesztendoAllat", requestDto);
        model.addAttribute("szerkesztendoId", id);
        model.addAttribute("gondozok", gondozoService.getAllGondozos());
        return "allatok-szerkesztes";  // allatok-szerkesztes.html
    }


    @PostMapping("/szerkesztes/{id}")
    public String updateAllat(@PathVariable Long id, @ModelAttribute("szerkesztendoAllat") AllatRequestDto requestDto) {
        allatService.updateAllat(id, requestDto);
        return "redirect:/allatok";
    }

    @PostMapping("/torles/{id}")
    public String deleteAllat(@PathVariable Long id) {
        allatService.deleteAllat(id);
        return "redirect:/allatok";
    }
}