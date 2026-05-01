package com.nye.university.nyeuni.dto.gondozo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class GondozoResponseDto {
    private Long id;
    private String terulet;
    private String gondozonev;
}
