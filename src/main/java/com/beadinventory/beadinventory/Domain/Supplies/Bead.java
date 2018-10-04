package com.beadinventory.beadinventory.Domain.Supplies;


import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.MaterialCategory;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape;

import javax.persistence.Id;
import javax.persistence.*;
import java.io.Serializable;
import java.util.TreeSet;

@Entity
public class Bead implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "BEAD_ID")
    private long id;

    private Material material;
    @Column(name = "MATERIAL")
    public String getMaterialString(){
        return material.toString();
    }

    private MaterialCategory materialCategory;
    @Column
    public String getMaterialCategoryString(){
        return materialCategory.toString();
    }

    private Shape shape;
    @Column(name = "SHAPE")
    public String getShapeString(){
        return shape.toString();
    }

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
        this.materialCategory = material.getCategory();
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

    public void setMaterialCategory(MaterialCategory materialCategory) {
        this.materialCategory = materialCategory;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public MaterialCategory getMaterialCategory() {
        return materialCategory;
    }

    public Shape getShape() {
        return shape;
    }

    public void setBrands(TreeSet<String> brands) {
        this.brands = brands;
    }

    public TreeSet<String> getBrands() {
        return brands;
    }

    public String getBrandsString(){
        String b = "";
        for (String item:brands) {
            b+= item;
        }
        return b;
    }

    public void setAll(Material material, Shape shape, String color, int size, String quality, long quantity,
                       String description, double pricePoint, TreeSet<String> brands){
        this.material = material;
        this.materialCategory = material.getCategory();
        this.shape = shape;
        this.color = color;
        this.size = size;
        this.quality = quality;
        this.quantity = quantity;
        this.description = description;
        this.pricePoint = pricePoint;
        this.brands = brands;
    }

    @Override
    public String toString(){
        return "Material: " + material + ", Shape: " + shape + ", Color: " + color + ", Size: " + size + "mm, Price point: "
                + pricePoint + ", Quality: " + quality + ", Quantity: " + quantity + ", Brands: " + getBrandsString() + ", Description: " +
                description;
    }
}
