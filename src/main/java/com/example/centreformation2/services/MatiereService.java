package com.example.centreformation2.services;

import com.example.centreformation2.entities.Matiere;
import com.example.centreformation2.repositories.MatiereRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MatiereService {
    @Autowired
    private MatiereRepo matiereRepo;

    public List<Matiere> findAll() {
        return this.matiereRepo.findAll();
    }

    public Matiere findById(Long id) {
        Optional<Matiere> optMatiere = this.matiereRepo.findById(id);

        if (optMatiere.isPresent()) {
            return optMatiere.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "pfff");
        }
    }

    public Matiere create(Matiere matiere) {
        return this.matiereRepo.save(matiere);
    }

    public Matiere update(Matiere matiere) {
        if (!this.matiereRepo.existsById(matiere.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "Le matiere à mettre à jour n'existe pas dans la bdd");
        } else {
            return this.matiereRepo.save(matiere);
        }
    }

    public Matiere delete(Long id) {
        if (!this.matiereRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La guitare à supprimer n'existe pas dans la bdd");
        } else {
            Matiere matiereDelete = this.findById(id);
            this.matiereRepo.deleteById(id);

            if (this.matiereRepo.existsById(id)) {
                throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                        "Erreur lors de la suppression du matiere : " + id);
            }

            return matiereDelete;
        }
    }
}
