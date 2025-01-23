package com.example.footballapi.service;

import com.example.footballapi.entity.Joueur;
import com.example.footballapi.repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoueurService {
    @Autowired
    private JoueurRepository joueurRepository;

    public List<Joueur> getAllJoueurs() {
        return joueurRepository.findAll();
    }

    public Joueur addJoueur(Joueur joueur) {
        return joueurRepository.save(joueur);
    }
}
