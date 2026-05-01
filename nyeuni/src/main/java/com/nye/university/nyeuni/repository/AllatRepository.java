package com.nye.university.nyeuni.repository;

import com.nye.university.nyeuni.entity.Allat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

//<Entity, Id típusa kell >
public interface AllatRepository extends JpaRepository<Allat, Long> {

}
