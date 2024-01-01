package com.jeuCarte;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.java.javaTest.model.Carte;
import com.java.javaTest.repository.CarteRepository;
import com.java.javaTest.service.CarteService;

@ExtendWith(MockitoExtension.class)
public class CarteServiceTest {

    
    @Mock
    private CarteRepository carteRepository;

    @InjectMocks
    private CarteService carteService;
	
    
    
    
    @Test
    public void testObtenirCartesMelangees() {
        List<Carte> cartes = Arrays.asList(new Carte("As", "Coeur"), new Carte("Roi", "Pique"));
        Mockito.when(carteRepository.findAll()).thenReturn(cartes);

        List<Carte> melangees = carteService.obtenirCartesMelangees();

        Assertions.assertNotNull(melangees);
        Assertions.assertEquals(2, melangees.size());
        // Vous pouvez ajouter d'autres assertions pour vérifier la logique de mélange si nécessaire.
    }
    
    @Test
    public void testGetCarte() {
        List<Carte> cartes = Arrays.asList(new Carte("Dame", "Trèfle"), new Carte("Valet", "Carreau"));
        Mockito.when(carteRepository.findAll()).thenReturn(cartes);

        List<Carte> result = carteService.getCarte();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("Dame", result.get(0).getValeur());
        Assertions.assertEquals("Trèfle", result.get(0).getCouleur());
    }

}
