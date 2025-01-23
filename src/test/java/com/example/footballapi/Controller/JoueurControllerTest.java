package com.example.footballapi.Controller;

import com.example.footballapi.config.SecurityConfig;
import com.example.footballapi.controller.JoueurController;
import com.example.footballapi.entity.Joueur;
import com.example.footballapi.service.JoueurService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(SecurityConfig.class)
@WebMvcTest(JoueurController.class)
public class JoueurControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JoueurService joueurService;

    private Joueur joueur1;
    private Joueur joueur2;

    @BeforeEach
    void setUp() {
        joueur1 = new Joueur();
        joueur1.setId(1L);
        joueur1.setName("Joueur A");

        joueur2 = new Joueur();
        joueur2.setId(2L);
        joueur2.setName("Joueur B");
    }

    @Test
    void testGetAllJoueurs() throws Exception {
        List<Joueur> joueursList = Arrays.asList(joueur1, joueur2);

        when(joueurService.getAllJoueurs()).thenReturn(joueursList);

        mockMvc.perform(get("/joueurs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Joueur A"));

    }

    @Test
    void testAddJoueur() throws Exception {
        when(joueurService.addJoueur(any(Joueur.class))).thenReturn(joueur1);

        mockMvc.perform(post("/joueurs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Joueur A\",\"position\":\"attaquant\"}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Joueur A"));
    }
}
