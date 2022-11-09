package com.example.centreformation2.controllers;

import com.example.centreformation2.entities.Adress;
import com.example.centreformation2.services.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/adresses")
public class AdressController {
    @Autowired
    private AdressService adressService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Adress> findAll() {
        return this.adressService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Adress findById(@PathVariable int id) {
        return this.adressService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public Adress create(@RequestBody Adress adress) {
        return this.adressService.create(adress);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Adress update(@RequestBody Adress adress, @PathVariable Long id) {
        if(!id.equals(adress.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvais adress à mettre à jour");
        }
        return this.adressService.update(adress);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Adress delete(@PathVariable int id) {
        return this.adressService.delete(id);
    }

}
