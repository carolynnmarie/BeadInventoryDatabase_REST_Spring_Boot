package com.beadinventory.beadinventory.Domain;


import com.beadinventory.beadinventory.Domain.beadCharacteristics.MaterialCategory;
import com.beadinventory.beadinventory.Domain.beadCharacteristics.Material;
import com.beadinventory.beadinventory.Domain.beadCharacteristics.Shape;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Bead implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    private Material material;

    @Enumerated(EnumType.STRING)
    @Column(name = "MATERIAL")
    public Material getMaterial(){
        return material;
    }

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

    public Bead(){
        this.material = null;
        this.color = "";
        this.size = 0;
        this.quantity = 0;
        this.quality = "";
        this.description = "";
    }

    public Bead(Material material, String color, int size, String quality, long quantity,
                String description) {
        this.material = material;
        this.color = color;
        this.size = size;
        this.quality = quality;
        this.quantity = quantity;
        this.description = description;
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
}
