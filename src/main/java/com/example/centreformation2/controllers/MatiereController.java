package com.example.centreformation2.controllers;

import com.example.centreformation2.entities.Matiere;
import com.example.centreformation2.services.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/matieres")
public class MatiereController {
    @Autowired
    private MatiereService matiereService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Matiere> findAll() {
        return this.matiereService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Matiere findById(@PathVariable Long id) {
        return this.matiereService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public Matiere create(@RequestBody Matiere matiere) {
        return this.matiereService.create(matiere);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Matiere update(@RequestBody Matiere matiere, @PathVariable Long id) {
        if(!id.equals(matiere.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvais matiere à mettre à jour");
        }
        return this.matiereService.update(matiere);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Matiere delete(@PathVariable Long id) {
        return this.matiereService.delete(id);
    }
}
