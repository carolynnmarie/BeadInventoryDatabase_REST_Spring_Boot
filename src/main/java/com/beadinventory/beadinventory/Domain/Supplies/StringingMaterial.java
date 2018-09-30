package com.beadinventory.beadinventory.Domain.Supplies;

import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.MaterialCategory;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringingMaterialCategory;


import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class StringingMaterial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "STRINGING_MATERIAL_ID")
    private int id;

    private StringingMaterialCategory category;
    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY")
    public StringingMaterialCategory getFindingCategory() {
        return category;
    }

    private Material material;
    @Enumerated(EnumType.STRING)
    @Column(name = "MATERIAL")
    public Material getMaterial(){
        return material;
    }


    @Column(name = "WIDTH")
    private int widthMM;

    @Column(name = "STRANDS")
    private int strands;

    @Column(name = "QUALITY")
    private String quality;

    @Column(name = "PRICE_PER_INCH")
    private double pricePerInch;

    @Column(name = "LENGTH")
    private double availableLength;

    @Column(name = "BRAND")
    private String brand;


    public StringingMaterial(StringingMaterialCategory category, Material material, int widthMM, int strands, String quality, double pricePerInch, double availableLength,String brand) {
        this.category = category;
        this.material = material;
        this.widthMM = widthMM;
        this.strands = strands;
        this.quality = quality;
        this.pricePerInch = pricePerInch;
        this.availableLength = availableLength;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getWidthMM() {
        return widthMM;
    }

    public void setWidthMM(int widthMM) {
        this.widthMM = widthMM;
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

    public double getAvailableLength() {
        return availableLength;
    }

    public void setAvailableLength(double availableLength) {
        this.availableLength = availableLength;
    }
}
