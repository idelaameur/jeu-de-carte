package com.java.javaTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.javaTest.model.Carte;

public interface CarteRepository extends JpaRepository<Carte, Long> {

}