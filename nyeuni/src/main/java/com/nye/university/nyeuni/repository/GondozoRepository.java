package com.nye.university.nyeuni.repository;

import com.nye.university.nyeuni.entity.Gondozo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//<Entity, Id típusa kell >
public interface GondozoRepository extends JpaRepository<Gondozo, Long> {


}
