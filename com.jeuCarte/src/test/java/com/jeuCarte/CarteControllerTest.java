package com.jeuCarte;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.java.javaTest.JavaTestApplication;
import com.java.javaTest.controller.CarteController;
import com.java.javaTest.model.Carte;
import com.java.javaTest.service.CarteService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@SpringBootTest(classes=JavaTestApplication.class)
public class CarteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarteService carteService;
    
    @Test
    public void testTrouverCarteParId() throws Exception {
    	  List<Carte> cartes = Arrays.asList(new Carte("As", "Coeur"), new Carte("Roi", "Pique"));
          Mockito.when(carteService.getCarte()).thenReturn(cartes);

        mockMvc.perform(get("/cartes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.valeur", is("As")))
                .andExpect(jsonPath("$.couleur", is("Coeur")));
    }

}
