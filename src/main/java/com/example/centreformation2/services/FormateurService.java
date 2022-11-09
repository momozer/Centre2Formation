package com.example.centreformation2.services;

import com.example.centreformation2.entities.Formateur;
import com.example.centreformation2.repositories.FormateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class FormateurService {
    @Autowired
    private FormateurRepo formateurRepo;

    public List<Formateur> findAll() {
        return this.formateurRepo.findAll();
    }

    public Formateur findById(Long id) {
        Optional<Formateur> optFormateur = this.formateurRepo.findById(id);

        if (optFormateur.isPresent()) {
            return optFormateur.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "pfff");
        }
    }

    public Formateur create(Formateur formateur) {
        return this.formateurRepo.save(formateur);
    }

    public Formateur update(Formateur formateur) {
        if (!this.formateurRepo.existsById(formateur.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "Le formateur à mettre à jour n'existe pas dans la bdd");
        } else {
            return this.formateurRepo.save(formateur);
        }
    }

    public Formateur delete(Long id) {
        if (!this.formateurRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La guitare à supprimer n'existe pas dans la bdd");
        } else {
            Formateur formateurDelete = this.findById(id);
            this.formateurRepo.deleteById(id);

            if (this.formateurRepo.existsById(id)) {
                throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                        "Erreur lors de la suppression du formateur : " + id);
            }

            return formateurDelete;
        }
    }
}
