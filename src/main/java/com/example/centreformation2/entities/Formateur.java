package com.example.centreformation2.entities;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "formateur")

public class Formateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "civilite")
    private String civilite;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "adresse")
    private Adress adresse ;

    @Column(name = "dateEmbauche")
    private Date dateEmbauche;

    @Column(name = "niveauExp")
    private Experience niveauExp;

    @Column(name = "statusInterne")
    private StatusIntern statusIntern;

    public Formateur() {

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public Adress getAdresse() {
        return adresse;
    }

    public void setAdresse(Adress adresse) {
        this.adresse = adresse;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Experience getNiveauExp() {
        return niveauExp;
    }

    public void setNiveauExp(Experience niveauExp) {
        this.niveauExp = niveauExp;
    }

    public StatusIntern getStatusIntern() {
        return statusIntern;
    }

    public void setStatusIntern(StatusIntern statusIntern) {
        this.statusIntern = statusIntern;
    }

    @Override
    public String toString() {
        return "Formateur{" +
                "id=" + id +
                ", civilite='" + civilite + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", adresse=" + adresse +
                ", dateEmbauche=" + dateEmbauche +
                ", niveauExp=" + niveauExp +
                ", statusIntern=" + statusIntern +
                '}';
    }

    public Formateur(long id, String civilite, String nom, String prenom, String email, Adress adresse, Date dateEmbauche, Experience niveauExp, StatusIntern statusIntern) {
        this.id = id;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.dateEmbauche = dateEmbauche;
        this.niveauExp = niveauExp;
        this.statusIntern = statusIntern;
    }
}
