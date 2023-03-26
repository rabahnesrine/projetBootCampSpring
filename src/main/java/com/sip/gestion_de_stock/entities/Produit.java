package com.sip.gestion_de_stock.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idProduit")
    private long id;

    @NotEmpty(message = "Please provide an libelle ")
    @Column(name = "libelle")
    private String libelle;
    @NotEmpty(message = "Please provide an description ")
    @Column(name = "description")
    private String description;

    @NotEmpty(message = "Please provide an photoFace ")
    @Column(name = "photoFace")
    private String photoFace;
    @NotEmpty(message = "Please provide an photoProfil ")
    @Column(name = "photoProfil")
    private String photoProfil;

    @NotEmpty(message = "Please provide an prix ")
    @Column(name = "prix")
    private float prix;
    @NotEmpty(message = "Please provide an prixPromotion ")
    @Column(name = "prixPromotion")
    private float prixPromotion;
    @NotEmpty(message = "Please provide an quantiteStock ")
    @Column(name = "quantiteStock")
    private float quantiteStock;

    @NotEmpty(message = "Please provide an dateExpiration ")
    @Column(name = "dateExpiration")
    private Date dateExpiration;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idFournisseur", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Fournisseur idFournisseur;


    public Produit() {
    }


    public Produit(long id, String libelle, String description, String photoFace, String photoProfil, float prix, float prixPromotion, float quantiteStock, Date dateExpiration, Fournisseur idFournisseur) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.photoFace = photoFace;
        this.photoProfil = photoProfil;
        this.prix = prix;
        this.prixPromotion = prixPromotion;
        this.quantiteStock = quantiteStock;
        this.dateExpiration = dateExpiration;
        this.idFournisseur = idFournisseur;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoFace() {
        return photoFace;
    }

    public void setPhotoFace(String photoFace) {
        this.photoFace = photoFace;
    }

    public String getPhotoProfil() {
        return photoProfil;
    }

    public void setPhotoProfil(String photoProfil) {
        this.photoProfil = photoProfil;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getPrixPromotion() {
        return prixPromotion;
    }

    public void setPrixPromotion(float prixPromotion) {
        this.prixPromotion = prixPromotion;
    }

    public float getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(float quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Fournisseur getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(Fournisseur idFournisseur) {
        this.idFournisseur = idFournisseur;
    }
}
