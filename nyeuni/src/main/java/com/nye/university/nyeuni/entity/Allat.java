package com.nye.university.nyeuni.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Állatok tábla létrehozása
@Entity
@Table(name = "allatok")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Allat {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Automatikusan generált azonosító
    private Long id;
    //ezt kötelező kitölteni
    @Column(nullable = false)
    private String nev;
    private Integer kor;
    @ManyToOne
    //A gondozo ID itt rendelödik hozzá az állathoz
    @JoinColumn (name = "gondozo_id")
    private Gondozo gondozo;

}

