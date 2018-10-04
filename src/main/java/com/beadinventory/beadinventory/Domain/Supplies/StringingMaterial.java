package com.beadinventory.beadinventory.Domain.Supplies;

import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringingMaterialCategory;


import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class StringingMaterial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "STRINGING_MATERIAL_ID")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "SM_CATEGORY")
    private StringingMaterialCategory sMCategory;

    @Enumerated(EnumType.STRING)
    @Column(name = "MATERIAL")
    private Material material;

    @Column(name = "WIDTH")
    private String width;

    @Column(name = "STRANDS")
    private int strands;

    @Column(name = "QUALITY")
    private String quality;

    @Column(name = "PRICE_PER_INCH")
    private double pricePerInch;

    @Column(name = "BRAND")
    private String brand;


    public StringingMaterial(StringingMaterialCategory sMCategory, Material material, String width, int strands, String quality,
                             double pricePerInch, String brand) {
        this.sMCategory = sMCategory;
        this.material = material;
        this.width = width;
        this.strands = strands;
        this.quality = quality;
        this.pricePerInch = pricePerInch;

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

    public StringingMaterialCategory getsMCategory() {
        return sMCategory;
    }

    public void setsMCategory(StringingMaterialCategory sMCategory) {
        this.sMCategory = sMCategory;
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

    public double getPricePerInch() {
        return pricePerInch;
    }

    public void setPricePerInch(double pricePerInch) {
        this.pricePerInch = pricePerInch;
    }

}
