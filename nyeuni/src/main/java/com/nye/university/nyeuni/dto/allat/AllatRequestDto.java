package com.nye.university.nyeuni.dto.allat;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllatRequestDto {
    @NotBlank(message = "Név megadasa kotelezo!")
    private String nev;
    private Integer kor;
    private Long gondozoId;
}
