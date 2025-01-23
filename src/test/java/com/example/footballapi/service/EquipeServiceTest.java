package com.example.footballapi.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.footballapi.entity.Equipe;
import com.example.footballapi.repository.EquipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.data.domain.*;

import java.util.Arrays;
import java.util.List;

public class EquipeServiceTest {

    @Mock
    private EquipeRepository equipeRepository;

    private EquipeService equipeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        equipeService = new EquipeService();
        equipeService.setEquipeRepository(equipeRepository);
    }

    @Test
    void testGetAllEquipes() {
        Equipe equipe1 = new Equipe();
        equipe1.setName("Equipe A");
        equipe1.setAcronym("EA");
        equipe1.setBudget(100000.0);

        Equipe equipe2 = new Equipe();
        equipe2.setName("Equipe B");
        equipe2.setAcronym("EB");
        equipe2.setBudget(200000.0);

        List<Equipe> equipes = Arrays.asList(equipe1, equipe2);

        Page<Equipe> page = new PageImpl<>(equipes, PageRequest.of(0, 10), equipes.size());

        when(equipeRepository.findAll(PageRequest.of(0, 10, Sort.by("name")))).thenReturn(page);

        Page<Equipe> result = equipeService.getAllEquipes(0, 10, "name");

        assertNotNull(result);
        assertEquals(2, result.getContent().size());
        assertEquals("Equipe A", result.getContent().get(0).getName());
        assertEquals("EA", result.getContent().get(0).getAcronym());
        assertEquals(100000.0, result.getContent().get(0).getBudget());
        assertEquals("Equipe B", result.getContent().get(1).getName());
        assertEquals("EB", result.getContent().get(1).getAcronym());
        assertEquals(200000.0, result.getContent().get(1).getBudget());
        verify(equipeRepository, times(1)).findAll(PageRequest.of(0, 10, Sort.by("name")));  // Verify the repository call
    }

    @Test
    void testGetAllEquipesEmpty() {
        Page<Equipe> emptyPage = new PageImpl<>(Arrays.asList(), PageRequest.of(0, 10), 0);

        when(equipeRepository.findAll(PageRequest.of(0, 10, Sort.by("name")))).thenReturn(emptyPage);

        Page<Equipe> result = equipeService.getAllEquipes(0, 10, "name");

        assertNotNull(result);
        assertTrue(result.getContent().isEmpty());
        verify(equipeRepository, times(1)).findAll(PageRequest.of(0, 10, Sort.by("name")));  // Verify the repository call
    }
}
