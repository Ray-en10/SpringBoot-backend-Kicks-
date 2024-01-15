package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_produit;
    private String lib;
    private float prix;
    private float qte;
    @ManyToOne
    @JoinColumn(name= "id_category")
    private Category category;

    @Override
    public String toString() {
        return "product{" +
                "id_produit=" + id_produit +
                ", lib='" + lib + '\'' +
                ", prix='" + prix + '\'' +
                ", qte='" + qte + '\'' +
                ", category=" + category +
                '}';
    }

    public product(){}

    public product(int id_produit, String lib, float prix, float qte, Category category) {
        this.id_produit = id_produit;
        this.lib = lib;
        this.prix = prix;
        this.qte = qte;
        this.category = category;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getQte() {
        return qte;
    }

    public void setQte(float qte) {
        this.qte = qte;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
