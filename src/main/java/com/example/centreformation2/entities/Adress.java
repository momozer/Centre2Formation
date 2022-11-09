package com.example.centreformation2.entities;

import javax.persistence.*;


@Entity
@Table(name = "adresse")
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "numero")
    private int numero;
    @Column(name="rue")
    private String rue;
    @Column(name="complement")
    private String complement;
    @Column(name="codePostal")
    private int codePostal;
    @Column(name="ville")
    private String ville;
    @Column(name="pays")
    private String pays;

    public Adress() {

    }

    @Override
    public String toString() {
        return "Adress{" +
                "numero=" + numero +
                ", rue='" + rue + '\'' +
                ", complement='" + complement + '\'' +
                ", codePostal=" + codePostal +
                ", ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Adress(int numero, String rue, String complement, int codePostal, String ville, String pays) {
        this.numero = numero;
        this.rue = rue;
        this.complement = complement;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
    }
}

