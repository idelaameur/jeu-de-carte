package com.java.javaTest.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JeuDeCartes {
	private static final Logger logger = LogManager.getLogger(JeuDeCartes.class);

    private List<Carte> cartes = new ArrayList<>();

    public JeuDeCartes() {
        String[] valeurs = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi"};
        String[] couleurs = {"Coeur", "Pique", "Carreau", "Trefle"};

        cartes = Stream.of(couleurs)
                .flatMap(couleur -> Stream.of(valeurs)
                .map(valeur -> new Carte(valeur, couleur)))
                .collect(Collectors.toList());
    }
    
    public List<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(List<Carte> cartes) {
		this.cartes = cartes;
	}

	public void afficherCartes() {
        cartes.forEach(carte -> logger.info(carte));
    }
}
