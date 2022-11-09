package com.example.centreformation2.controllers;

import com.example.centreformation2.entities.Formateur;
import com.example.centreformation2.services.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/formateurs")
public class FormateurController {
    @Autowired
    private FormateurService formateurService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Formateur> findAll() {
        return this.formateurService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Formateur findById(@PathVariable Long id) {
        return this.formateurService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public Formateur create(@RequestBody Formateur formateur) {
        return this.formateurService.create(formateur);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Formateur update(@RequestBody Formateur formateur, @PathVariable Long id) {
        if(!id.equals(formateur.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvais formateur à mettre à jour");
        }
        return this.formateurService.update(formateur);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Formateur delete(@PathVariable Long id) {
        return this.formateurService.delete(id);
    }
}
