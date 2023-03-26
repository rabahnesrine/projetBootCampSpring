package com.sip.gestion_de_stock.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class Fournisseur {
    @Id
    @GeneratedValue
    @Column(name="idFournisseur")
    private long id;
    @NotEmpty(message = "Please provide an logo  ")
    @Column(name="logo")
    private String logo;
    @NotEmpty(message="Please provide an nom ")
    @Column(name="nom")
    private String nom;
    @Column(name="email")
    @Email(message="Please provide a valid Email")
    @NotEmpty(message="Please provide an email ")
    private String email;
    @NotEmpty(message="Please provide an telephone ")
    @Column(name="telephone")
    private String telephone;
    @NotEmpty(message="Please provide an adresse ")
    @Column(name="adresse")
    private String adresse;


    public Fournisseur() {
    }

    public Fournisseur(long id, String logo, String nom, String email, String telephone, String adresse) {
        this.id = id;
        this.logo = logo;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
