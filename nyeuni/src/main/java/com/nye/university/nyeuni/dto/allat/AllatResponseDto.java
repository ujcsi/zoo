package com.nye.university.nyeuni.dto.allat;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class AllatResponseDto {
    private Long id;
    private String nev;
    private Integer kor;
    private Long gondozoId;
    private String gondozoterulet;

}
