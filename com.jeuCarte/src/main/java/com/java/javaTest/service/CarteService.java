package com.java.javaTest.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.javaTest.model.Carte;
import com.java.javaTest.repository.CarteRepository;

import jakarta.transaction.Transactional;

@Service
public class CarteService {

    @Autowired
    private CarteRepository carteRepository;

    @Transactional
    public void enregistrerCartes(List<Carte> cartes) {
        carteRepository.saveAll(cartes);
    }
    
    public List<Carte> obtenirCartesMelangees() {
        List<Carte> cartes = carteRepository.findAll();
        Collections.shuffle(cartes);
        return cartes;
    }
    
    public List<Carte> getCarte(){
    	return carteRepository.findAll();
    }
}