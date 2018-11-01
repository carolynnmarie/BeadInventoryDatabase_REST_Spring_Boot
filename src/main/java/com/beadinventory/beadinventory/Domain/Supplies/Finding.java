package com.beadinventory.beadinventory.Domain.Supplies;

import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "FINDING")
public class Finding implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FINDING_ID")
    private long id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "CATEGORY")
    private FindingCategory category;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "MATERIAL")
    private Material material;

    @Column
    private String description;

    @Column(name = "LENGTH_CM")
    private double lengthCM;

    @Column
    private double pricePoint;

    @Column
    private long quantity;

    @Column
    private String brand;



    public Finding(){}

    public Finding(FindingCategory category, Material material, double lengthCM, double pricePoint,
                   int quantity, String brand, String description) {
        this.category = category;
        this.material = material;
        this.description = description;
        this.lengthCM = lengthCM;
        this.pricePoint = pricePoint;
        this.quantity = quantity;
        this.brand = brand;
    }

//    public void setAllId(long id){
//        this.id = id;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id){
        this.id = id;
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

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void setFindingCategory(FindingCategory category) {
        this.category = category;
    }

    public double getLengthCM() {
        return lengthCM;
    }

    public void setLengthCM(double lengthCM) {
        this.lengthCM = lengthCM;
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

    public FindingCategory getFindingCategory() {
        return category;
    }

    public void setCategory(FindingCategory category) {
        this.category = category;
    }

    public Material getMaterial() {
        return material;
    }

    @Override
    public String toString(){
        return "Finding: " + category + ", material: " + material.toString() + ", length in cm: " + lengthCM +
                ", description: " + description;
    }

}
