package com.beadinventory.beadinventory.Domain.Supplies;

import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
public class Finding {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "FINDING_ID")
    private long id;

    private FindingCategory category;
    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY")
    public FindingCategory getFindingCategory() {
        return category;
    }

    private Material material;
    @Enumerated(EnumType.STRING)
    @Column(name = "MATERIAL")
    public Material getMaterial(){
        return material;
    }

    @Column(name = "DETAILS")
    private String details;

    @Column(name = "LENGTH")
    private int length;

    @Column(name = "WIDTH")
    private int width;

    @Column(name = "PRICE_POINT")
    private double pricePoint;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "BRAND")
    private String brand;

    public Finding(FindingCategory category, Material material, String details, int length, int width, double pricePoint,
                   int quantity, String brand) {
        this.category = category;
        this.material = material;
        this.details = details;
        this.length = length;
        this.width = width;
        this.pricePoint = pricePoint;
        this.quantity = quantity;
        this.brand = brand;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getPricePoint() {
        return pricePoint;
    }

    public void setPricePoint(double pricePoint) {
        this.pricePoint = pricePoint;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setFindingCategory(FindingCategory category) {
        this.category = category;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
