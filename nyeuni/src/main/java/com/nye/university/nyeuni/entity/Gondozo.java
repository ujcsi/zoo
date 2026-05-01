package com.nye.university.nyeuni.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;




    //ellől lesz adatbázis tábla
    @Entity
    //a gondozo tabla neve
    @Table(name = "gondozok")
    //lombokból kapott get-terek szet-terek tostring
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder


    public class Gondozo {

        @Id
        //Automatikusan generált azonosító
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        //ezt kötelező kitölteni
        @Column(nullable = false)
        private String terulet;

        private String gondozonev;

        @OneToMany(mappedBy = "gondozo")

        // A hozzájuk tartozó állatok
        private List<Allat> allatok = new ArrayList<>();

}
