package com.beadinventory.beadinventory.Domain.Supplies;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
public class Finding {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    private FindingCategory category;
    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY")
    public FindingCategory getCategory() {
        return category;
    }

    @Column(name = "TYPE")
    private String type;

    @Column(name = "DETAILS")
    private String details;

    @Column(name = "SIZE")
    private int sizeMM;

    @Column(name = "PRICE_POINT")
    private double pricePoint;

    @Column(name = "QUANTITY")
    private int quantity;

    public Finding(String details, double pricePoint, int quantity) {
        this.details = details;
        this.pricePoint = pricePoint;
        this.quantity = quantity;
    }

    public int getId() {
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

    public void setCategory(FindingCategory category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSizeMM() {
        return sizeMM;
    }

    public void setSizeMM(int sizeMM) {
        this.sizeMM = sizeMM;
    }
}
