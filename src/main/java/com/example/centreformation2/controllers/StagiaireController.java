package com.example.centreformation2.controllers;

import com.example.centreformation2.entities.Stagiaire;
import com.example.centreformation2.services.StagiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/stagiaires")
public class StagiaireController {
    @Autowired
    private StagiaireService stagiaireService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Stagiaire> findAll() {
        return this.stagiaireService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Stagiaire findById(@PathVariable Long id) {
        return this.stagiaireService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public Stagiaire create(@RequestBody Stagiaire stagiaire) {
        return this.stagiaireService.create(stagiaire);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Stagiaire update(@RequestBody Stagiaire stagiaire, @PathVariable Long id) {
        if(!id.equals(stagiaire.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvais stagiaire à mettre à jour");
        }
        return this.stagiaireService.update(stagiaire);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Stagiaire delete(@PathVariable Long id) {
        return this.stagiaireService.delete(id);
    }
}
