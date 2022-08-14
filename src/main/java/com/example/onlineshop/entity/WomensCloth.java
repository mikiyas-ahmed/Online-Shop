package com.example.onlineshop.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class WomensCloth {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="women_cloth_seq")
    @SequenceGenerator(name = "women_cloth_seq", allocationSize = 1)
    private long womenClothId;

    @NotNull
    @Size(min=2, max=50)
    private String size;

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

    public long getWomenClothId() {
        return womenClothId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
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
