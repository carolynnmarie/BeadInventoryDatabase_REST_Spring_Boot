package com.beadinventory.beadinventory.Domain.Supplies;

import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory;


import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Table(name = "STRING_WIRE")
public class StringWire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STRING_ID")
    private long id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "STRING_CATEGORY")
    private StringWireCategory stringWireCategory;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "MATERIAL")
    private Material material;

    @Column
    private String color;

    @Column
    private String width;

    @Column
    private String quality;

    @Column(name = "PRICE_PER_FOOT")
    private double pricePerFoot;

    @Column
    private String brand;

    @Column
    private String description;

    public StringWire(){ }

    public StringWire(StringWireCategory stringWireCategory, Material material, String color, String width, String quality,
                      double pricePerFoot, String brand, String description) {
        this.stringWireCategory = stringWireCategory;
        this.material = material;
        this.quality = quality;
        this.pricePerFoot = pricePerFoot;
        this.brand = brand;
        this.description = description;
        this.color = color;
        this.width = width;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Material getMaterial(){
        return material;
    }

    public StringWireCategory getStringWireCategory() {
        return stringWireCategory;
    }

    public void setStringWireCategory(StringWireCategory stringWireCategory) {
        this.stringWireCategory = stringWireCategory;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public double getPricePerFoot() {
        return pricePerFoot;
    }

    public void setPricePerFoot(double pricePerFoot) {
        this.pricePerFoot = pricePerFoot;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString(){
        return "Stringing Material: type: " + stringWireCategory.toString() + ", material: " + material.toString() +
                ", color: " + color + ", description: " + description;
    }
}
