package com.example.footballapi.service;

import com.example.footballapi.entity.Equipe;
import com.example.footballapi.repository.EquipeRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Setter
@Service
public class EquipeService {
    @Autowired
    private EquipeRepository equipeRepository;

    public Page<Equipe> getAllEquipes(int page, int size, String sortBy) {
        return equipeRepository.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
    }

    public Equipe addEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    public Optional<Equipe> getEquipeById(Long id) {
        return equipeRepository.findById(id);
    }
}
