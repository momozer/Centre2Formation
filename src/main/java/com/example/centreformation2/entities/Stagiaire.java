package com.example.centreformation2.entities;

import javax.persistence.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stagiaire")
public class Stagiaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "civilite")
    private String civilite;

    @Column(name = "nom")
    private String name;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "dateNaissance")
    private Date dateNaissance;

    public Stagiaire() {

    }

    @Override
    public String toString() {
        return "Stagiaire{" +
                "id=" + id +
                ", civilite='" + civilite + '\'' +
                ", name='" + name + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", dateNaissance=" + dateNaissance +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Stagiaire(long id, String civilite, String name, String prenom, String email, Date dateNaissance) {
        this.id = id;
        this.civilite = civilite;
        this.name = name;
        this.prenom = prenom;
        this.email = email;
        this.dateNaissance = dateNaissance;
    }
}