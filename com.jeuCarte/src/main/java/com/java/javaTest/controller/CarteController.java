package com.java.javaTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.javaTest.model.Carte;
import com.java.javaTest.service.CarteService;

@RestController
@RequestMapping("/cartes")
public class CarteController {

    @Autowired
    private CarteService carteService;

    @GetMapping
    public ResponseEntity<List<Carte>> listerCartes() {
        List<Carte> cartes = carteService.getCarte();
        return ResponseEntity.ok(cartes);
    }
    
    @GetMapping("/melangees")
    public ResponseEntity<List<Carte>> afficherCartesMelangees() {
        List<Carte> cartesMelangees = carteService.obtenirCartesMelangees();
        return ResponseEntity.ok(cartesMelangees);
    }
    
}