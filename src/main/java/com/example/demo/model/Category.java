package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id_category;
    private String name;



    @Override
    public String toString() {
        return "Category{" +
                "id_category=" + id_category +
                ", name='" + name + '\'' +
                '}';
    }

    public Category(int id_category, String name) {
        this.id_category = id_category;
        this.name = name;
    }

    public Category() {}



    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
