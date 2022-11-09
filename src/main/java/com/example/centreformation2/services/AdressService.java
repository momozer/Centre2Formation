package com.example.centreformation2.services;

import com.example.centreformation2.entities.Adress;
import com.example.centreformation2.repositories.AdressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AdressService {
    @Autowired
    private AdressRepo adressRepo;

    public List<Adress> findAll() {
        return this.adressRepo.findAll();
    }

    public Adress findById(int id) {
        Optional<Adress> optAdress = this.adressRepo.findById(id);

        if (optAdress.isPresent()) {
            return optAdress.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "pfff");
        }
    }

    public Adress create(Adress adress) {
        return this.adressRepo.save(adress);
    }

    public Adress update(Adress adress) {
        if (!this.adressRepo.existsById(adress.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "Le adress à mettre à jour n'existe pas dans la bdd");
        } else {
            return this.adressRepo.save(adress);
        }
    }

    public Adress delete(int id) {
        if (!this.adressRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'adresse à supprimer n'existe pas dans la bdd");
        } else {
            Adress adressDelete = this.findById(id);
            this.adressRepo.deleteById(id);

            if (this.adressRepo.existsById(id)) {
                throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                        "Erreur lors de la suppression du adress : " + id);
            }

            return adressDelete;
        }
    }
}
