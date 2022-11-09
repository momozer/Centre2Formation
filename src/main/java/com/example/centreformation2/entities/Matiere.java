package com.example.centreformation2.entities;

import javax.persistence.*;

import javax.persistence.Entity;
import java.time.LocalTime;

@Entity
@Table(name = "matieres")
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "duree")
    private LocalTime duree;

    @Column(name = "difficulte")
    private Difficulte difficulte;

    public Matiere() {

    }


    public Matiere(String nom, LocalTime duree, Difficulte difficulte) {
        this.nom = nom;
        this.duree = duree;
        this.difficulte = difficulte;
    }

    public Matiere(Long id, String nom, LocalTime duree, Difficulte difficulte) {
        this.id = id;
        this.nom = nom;
        this.duree = duree;
        this.difficulte = difficulte;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalTime getDuree() {
        return duree;
    }

    public void setDuree(LocalTime duree) {
        this.duree = duree;
    }

    public Difficulte getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(Difficulte difficulte) {
        this.difficulte = difficulte;
    }
}