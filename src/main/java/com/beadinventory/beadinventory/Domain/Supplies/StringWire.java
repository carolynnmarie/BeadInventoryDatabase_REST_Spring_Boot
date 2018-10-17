package com.beadinventory.beadinventory.Domain.Supplies;

import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory;


import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Table(name = "stringing_materials")
public class StringWire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "STRINGING_MATERIAL_ID")
    private long id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "CATEGORY")
    private StringWireCategory stringWireCategory;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "MATERIAL")
    private Material material;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "WIDTH")
    private String width;

    @Column(name = "STRANDS")
    private int strands;

    @Column(name = "QUALITY")
    private String quality;

    @Column(name = "PRICE_PER_FOOT")
    private double pricePerFoot;

    @Column(name = "BRAND")
    private String brand;

    public StringWire(){ }

    public StringWire(StringWireCategory stringWireCategory, Material material, String color, String width, int strands, String quality,
                      double pricePerFoot, String brand) {
        this.stringWireCategory = stringWireCategory;
        this.material = material;
        this.width = width;
        this.strands = strands;
        this.quality = quality;
        this.pricePerFoot = pricePerFoot;
        this.color = color;
        this.brand = brand;
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

    public int getStrands() {
        return strands;
    }

    public void setStrands(int strands) {
        this.strands = strands;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
