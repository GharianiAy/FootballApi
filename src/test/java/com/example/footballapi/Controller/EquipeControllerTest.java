package com.example.footballapi.Controller;

import com.example.footballapi.config.SecurityConfig;
import com.example.footballapi.controller.EquipeController;
import com.example.footballapi.entity.Equipe;
import com.example.footballapi.service.EquipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.*;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(SecurityConfig.class)
@WebMvcTest(EquipeController.class)
public class EquipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EquipeService equipeService;

    private Equipe equipe;

    @BeforeEach
    void setUp() {
        equipe = new Equipe();
        equipe.setId(1L);
        equipe.setName("Equipe A");
        equipe.setAcronym("EA");
        equipe.setBudget(1000000.0);
    }

    @Test
    void testGetAllEquipes() throws Exception {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("name"));
        Page<Equipe> equipesPage = new PageImpl<>(Arrays.asList(equipe), pageable, 1);

        when(equipeService.getAllEquipes(0, 10, "name")).thenReturn(equipesPage);

        mockMvc.perform(get("/equipes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].name").value("Equipe A"))
                .andExpect(jsonPath("$.content[0].acronym").value("EA"));
    }

    @Test
    void testAddEquipe() throws Exception {
        when(equipeService.addEquipe(any(Equipe.class))).thenReturn(equipe);

        mockMvc.perform(post("/equipes")
                        .contentType("application/json")
                        .content("{\"name\":\"Equipe A\", \"acronym\":\"EA\", \"budget\":1000000}")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Equipe A"));
    }
}