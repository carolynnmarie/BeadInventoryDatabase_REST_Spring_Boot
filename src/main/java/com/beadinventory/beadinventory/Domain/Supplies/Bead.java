package com.beadinventory.beadinventory.Domain.Supplies;


import com.beadinventory.beadinventory.Domain.Supplies.beadAspects.MaterialCategory;
import com.beadinventory.beadinventory.Domain.Supplies.beadAspects.Material;
import com.beadinventory.beadinventory.Domain.Supplies.beadAspects.Shape;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Bead implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "MATERIAL")
    private Material material;

    private MaterialCategory materialCategory;
    @Enumerated(EnumType.STRING)
    @Column(name = "MATERIAL_CATEGORY")
    public MaterialCategory getMaterialCategory(){
        return material.getCategory();
    }

    private Shape shape;
    @Enumerated(EnumType.STRING)
    @Column(name = "SHAPE")
    public Shape getShape(){
        return shape;
    }

    @Column(name = "COLOR")
    private String color;

    @Column(name = "SIZE")
    private int size;

    @Column(name = "QUALITY")
    private String quality;

    @Column(name = "QUANTITY")
    private long quantity;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE_POINT")
    private double pricePoint;

    @Column(name = "BRAND")
    private String brands;

    public Bead(){
        this.material = null;
        this.materialCategory = material.getCategory();
        this.color = "";
        this.size = 0;
        this.quantity = 0;
        this.quality = "";
        this.description = "";
        this.pricePoint = 0.0;
        this.brands = "";
    }

    public Bead(Material material, String color, int size, String quality, long quantity,
                String description, double pricePoint, String brands) {
        this.material = material;
        this.materialCategory = material.getCategory();
        this.color = color;
        this.size = size;
        this.quality = quality;
        this.quantity = quantity;
        this.description = description;
        this.pricePoint = pricePoint;
        this.brands = brands;
    }

    public Material getMaterial(){
        return material;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPricePoint() {
        return pricePoint;
    }

    public void setPricePoint(double pricePoint) {
        this.pricePoint = pricePoint;
    }
}
