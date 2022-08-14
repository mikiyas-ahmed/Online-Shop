package com.example.onlineshop.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class MensCloth {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="men_cloth_seq")
    @SequenceGenerator(name = "men_cloth_seq", allocationSize = 1)
    private long menClothId;

    @NotNull
    @Size(min=2, max=50)
    private int size;

    @NotNull
    @Size(min=1, max=50)
    private String color;

    @NotNull
    @Column(unique=true)
    private String model_name;

    @NotNull
    private String description;

    @NotNull
    private int price;

    public MensCloth() {
    }

    public long getMenClothId() {
        return menClothId;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
