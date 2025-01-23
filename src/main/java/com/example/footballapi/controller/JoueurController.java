package com.example.footballapi.controller;

import com.example.footballapi.entity.Joueur;
import com.example.footballapi.service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController  // REST controller for player management
@RequestMapping("/joueurs")  // Base URL for this controller
public class JoueurController {

    @Autowired
    private JoueurService joueurService;

    @GetMapping  // GET request to retrieve all players
    public List<Joueur> getAllJoueurs() {
        return joueurService.getAllJoueurs();
    }

    @PostMapping  // POST request to add a new player
    public Joueur addJoueur(@Valid @RequestBody Joueur joueur) {
        return joueurService.addJoueur(joueur);
    }
}