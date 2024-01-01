package com.java.javaTest.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Carte {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String valeur;
    private String couleur;
    
    private static final Logger logger = LogManager.getLogger(Carte.class);

    public Carte(String valeur, String couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
        logger.info("Création de la carte: " + this);
    }
    
    public Carte() {
        // Constructeur par défaut nécessaire pour JPA
    }

    public String getValeur() {
        return valeur;
    }

    public String getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return valeur + " de " + couleur;
    }
}
