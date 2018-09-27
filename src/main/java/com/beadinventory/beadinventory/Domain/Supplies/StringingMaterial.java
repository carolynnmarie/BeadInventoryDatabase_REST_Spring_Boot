package com.beadinventory.beadinventory.Domain.Supplies;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class StringingMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private int id;

    @Column(name = "MATERIAL")
    private String material;

    @Column(name = "WIDTH")
    private int widthMM;

    @Column(name = "STRANDS")
    private int strands;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "QUALITY")
    private String quality;

    @Column(name = "PRICE_PER_INCH")
    private double pricePerInch;

    @Column(name = "LENGTH")
    private double availableLength;

    public StringingMaterial(String material, int widthMM, int strands, String brand, String quality, double pricePerInch, double availableLength) {
        this.material = material;
        this.widthMM = widthMM;
        this.strands = strands;
        this.brand = brand;
        this.quality = quality;
        this.pricePerInch = pricePerInch;
        this.availableLength = availableLength;
    }

    public int getId() {
        return id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
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
