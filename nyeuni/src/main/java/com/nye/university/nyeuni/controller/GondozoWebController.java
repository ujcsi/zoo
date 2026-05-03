package com.nye.university.nyeuni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GondozoWebController {

    @GetMapping("/gondozok")
    public String gondozok() {
        return "gondozok";
    }
}

/*package com.nye.university.nyeuni.controller;

import com.nye.university.nyeuni.dto.gondozo.GondozoRequestDto;
import com.nye.university.nyeuni.dto.gondozo.GondozoResponseDto;
import com.nye.university.nyeuni.service.GondozoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/gondozo")
@RequiredArgsConstructor
public class GondozoWebController {

    private final GondozoService gondozoService;

    // Főoldal - összes gondozó listája
    @GetMapping
    public String listGondozok(Model model) {
        List<GondozoResponseDto> gondozok = gondozoService.getAllGondozos();
        model.addAttribute("gondozok", gondozok);
        return "gondozo/list";
    }

    // Új gondozó űrlap megjelenítése
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("gondozo", new GondozoRequestDto());
        return "gondozo/create";
    }

    // Új gondozó mentése
    @PostMapping("/create")
    public String createGondozo(@ModelAttribute GondozoRequestDto requestDto,
                                RedirectAttributes redirectAttributes) {
        try {
            gondozoService.createGondozo(requestDto);
            redirectAttributes.addFlashAttribute("success", "Gondozó sikeresen létrehozva!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Hiba történt a létrehozáskor!");
        }
        return "redirect:/gondozo";
    }

    // Gondozó szerkesztő űrlap megjelenítése
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            GondozoResponseDto gondozo = gondozoService.getGondozoById(id);
            model.addAttribute("gondozo", gondozo);
            return "gondozo/edit";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Gondozó nem található!");
            return "redirect:/gondozo";
        }
    }

    // Gondozó frissítése
    @PostMapping("/update/{id}")
    public String updateGondozo(@PathVariable Long id,
                                @ModelAttribute GondozoRequestDto requestDto,
                                RedirectAttributes redirectAttributes) {
        try {
            gondozoService.updateGondozo(id, requestDto);
            redirectAttributes.addFlashAttribute("success", "Gondozó sikeresen frissítve!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Hiba történt a frissítéskor!");
        }
        return "redirect:/gondozo";
    }

    // Gondozó törlése
    @GetMapping("/delete/{id}")
    public String deleteGondozo(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            gondozoService.deleteGondozo(id);
            redirectAttributes.addFlashAttribute("success", "Gondozó sikeresen törölve!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Hiba történt a törléskor!");
        }
        return "redirect:/gondozo";
    }

    // Gondozó részletei
    @GetMapping("/view/{id}")
    public String viewGondozo(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            GondozoResponseDto gondozo = gondozoService.getGondozoById(id);
            model.addAttribute("gondozo", gondozo);
            return "gondozo/view";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Gondozó nem található!");
            return "redirect:/gondozo";
        }
    }
}

 */