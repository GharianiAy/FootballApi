package com.example.footballapi.controller;

import com.example.footballapi.entity.Equipe;
import com.example.footballapi.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController  // REST controller for handling requests
@RequestMapping("/equipes")  // Base URL for this controller
public class EquipeController {

    @Autowired
    private EquipeService equipeService;

    @GetMapping  // GET request to retrieve paginated teams
    public Page<Equipe> getAllEquipes(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size,
                                      @RequestParam(defaultValue = "name") String sortBy) {
        return equipeService.getAllEquipes(page, size, sortBy);
    }

    @PostMapping  // POST request to add a new team
    public Equipe addEquipe(@Valid @RequestBody Equipe equipe) {
        return equipeService.addEquipe(equipe);
    }
}
