package com.beadinventory.beadinventory.Domain.Supplies;

import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BEADS")
public class Bead implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BEAD_ID")
    private long id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "MATERIAL")
    private Material material;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "SHAPE")
    private Shape shape;

    @Column
    private String color;

    @Column(name = "SIZE_MM")
    private int sizeMM;

    @Column
    private String quality;

    @Column
    private long quantity;

    @Column
    private String description;

    @Column
    private double pricePoint;

    @Column
    private String brands;


    public Bead(){ }


    public Bead(Material material, Shape shape, String color, int sizeMM, String quality, long quantity,
                String description, double pricePoint, String brands) {
        this.material = material;
        this.shape = shape;
        this.color = color;
        this.sizeMM = sizeMM;
        this.quality = quality;
        this.quantity = quantity;
        this.description = description;
        this.pricePoint = pricePoint;
        this.brands = brands;

    }

    public Material getMaterial(){
        return material;
    }

    public void setBeadId(long beadId){
        this.id = beadId;
    }

    public long getBeadId(){
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

    public int getSizeMM() {
        return sizeMM;
    }

    public void setSizeMM(int sizeMM) {
        this.sizeMM = sizeMM;
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

    public double getPricePoint() {
        return pricePoint;
    }

    public void setPricePoint(double pricePoint) {
        this.pricePoint = pricePoint;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Shape getShape() {
        return shape;
    }


    public void setBrands(String brands) {
        this.brands = brands;
    }

    public String getBrands() {
        return brands;
    }

    @Override
    public String toString(){
        return "Bead: material: " + material.toString() + " color: " + color + " shape: " + shape.toString() + " size: " + sizeMM;
    }

    public String toStringWithId(){
        return "Bead: id:" + id + ", material: " + material.toString() + " color: " + color + " shape: " + shape.toString() +
                " size: " + sizeMM;
    }

}
