package com.beadinventory.beadinventory.Domain.Supplies;


import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.MaterialCategory;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape;

import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.TreeSet;

@Entity
public class Bead implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "BEAD_ID")
    @NotNull
    private long id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "MATERIAL")
    private Material material;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "SHAPE")
    private Shape shape;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "SIZE")
    private int size;

    @Column(name = "QUALITY")
    private String quality;

    @Column(name = "QUANTITY")
    private long quantity;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE_POINT")
    private double pricePoint;

    @Column(name = "BRANDS")
    private TreeSet<String> brands;

    public Bead(){ }

    public Bead(Material material, Shape shape, String color, int size, String quality, long quantity,
                String description, double pricePoint, TreeSet<String> brands) {
        this.material = material;
        this.shape = shape;
        this.color = color;
        this.size = size;
        this.quality = quality;
        this.quantity = quantity;
        this.description = description;
        this.pricePoint = pricePoint;
        this.brands = brands;
    }

    public Material getMaterial(){
        return material;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getId(){
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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

    public String getMaterialString(){
        return material.toString();
    }

    public String getShapeString(){
        return shape.toString();
    }

    public void setBrands(TreeSet<String> brands) {
        this.brands = brands;
    }

    public TreeSet<String> getBrands() {
        return brands;
    }

    public String getBrandsString(){
        StringBuilder builder = new StringBuilder();
        brands.stream().forEach(e-> builder.append(e).append(" "));
        return builder.toString();
    }

//    @Override
//    public String toString(){
//        return "Material: " + material + ", Shape: " + shape + ", Color: " + color + ", Size: " + size + "mm, Price point: "
//                + pricePoint + ", Quality: " + quality + ", Quantity: " + quantity + ", Brands: " + getBrandsString() + ", Description: " +
//                description;
//    }
}
