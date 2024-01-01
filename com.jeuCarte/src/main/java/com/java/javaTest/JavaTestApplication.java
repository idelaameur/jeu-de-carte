package com.java.javaTest;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.java.javaTest.model.Carte;
import com.java.javaTest.model.JeuDeCartes;
import com.java.javaTest.service.CarteService;

@SpringBootApplication
public class JavaTestApplication {

	@Autowired
    private CarteService carteService;

	private static final Logger logger = LogManager.getLogger(JavaTestApplication.class);
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
        jeu.afficherCartes();
        
        
        ConfigurableApplicationContext context = SpringApplication.run(JavaTestApplication.class, args);
        CarteService carteService = context.getBean(CarteService.class);

        // Création des cartes et appel du service
        List<Carte> cartes = jeu.getCartes();
        carteService.enregistrerCartes(cartes);
        
		
	}

}
