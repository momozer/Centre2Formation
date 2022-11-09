package com.example.centreformation2.services;


import com.example.centreformation2.entities.Stagiaire;
import com.example.centreformation2.repositories.StagiaireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StagiaireService {
    @Autowired
    private StagiaireRepo stagiaireRepo;

    public List<Stagiaire> findAll() {
        return this.stagiaireRepo.findAll();
    }

    public Stagiaire findById(Long id) {
        Optional<Stagiaire> optStagiaire = this.stagiaireRepo.findById(id);

        if (optStagiaire.isPresent()) {
            return optStagiaire.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "pfff");
        }
    }

    public Stagiaire create(Stagiaire stagiaire) {
        return this.stagiaireRepo.save(stagiaire);
    }

    public Stagiaire update(Stagiaire stagiaire) {
        if (!this.stagiaireRepo.existsById(stagiaire.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "Le stagiaire à mettre à jour n'existe pas dans la bdd");
        } else {
            return this.stagiaireRepo.save(stagiaire);
        }
    }

    public Stagiaire delete(Long id) {
        if (!this.stagiaireRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La guitare à supprimer n'existe pas dans la bdd");
        } else {
            Stagiaire stagiaireDelete = this.findById(id);
            this.stagiaireRepo.deleteById(id);

            if (this.stagiaireRepo.existsById(id)) {
                throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                        "Erreur lors de la suppression du stagiaire : " + id);
            }

            return stagiaireDelete;
        }
    }
}
