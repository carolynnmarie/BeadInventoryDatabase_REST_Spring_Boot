package com.beadinventory.beadinventory.Domain.Supplies;

import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;

import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.TreeSet;

@Entity
public class Finding implements Serializable {

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
    private double lengthCM;

    @Column(name = "PRICE_POINT")
    private double pricePoint;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "BRAND")
    private TreeSet<String> brand;

    public Finding(FindingCategory category, Material material, String details, double lengthCM, double pricePoint,
                   int quantity, TreeSet<String> brand) {
        this.category = category;
        this.material = material;
        this.details = details;
        this.lengthCM = lengthCM;
        this.pricePoint = pricePoint;
        this.quantity = quantity;
        this.brand = brand;
    }

//    public void setId(long id){
//        this.id = id;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id){
        this.id = id;
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

    public double getLengthCM() {
        return lengthCM;
    }

    public void setLengthCM(double lengthCM) {
        this.lengthCM = lengthCM;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public TreeSet<String> getBrand() {
        return brand;
    }

    public void setBrand(TreeSet<String> brand) {
        this.brand = brand;
    }
}
