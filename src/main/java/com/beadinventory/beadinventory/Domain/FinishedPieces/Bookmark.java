package com.beadinventory.beadinventory.Domain.FinishedPieces;


import com.beadinventory.beadinventory.Domain.Supplies.*;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "BOOKMARK")
public class Bookmark extends AllFinishedPieces implements Serializable {


    @Enumerated(value = EnumType.STRING)
    @Column(name = "STRING_MATERIAL")
    private Material stringMaterial;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "STRING_CATEGORY")
    private StringWireCategory stringCategory;

    @Column(name = "STRING_COLOR")
    private String stringColor;

    @Column(name = "LENGTH")
    private int lengthInch;


    public Bookmark(){}

    public Bookmark(HashMap<Bead, Integer> beads, HashMap<Finding, Integer> findings, double price, String description,
                    Material stringMaterial, StringWireCategory stringCategory, String stringColor, int lengthInch) {
        super(beads, findings, price, description);
        this.stringMaterial = stringMaterial;
        this.stringCategory = stringCategory;
        this.lengthInch = lengthInch;
        this.stringColor = stringColor;
    }

    public Material getStringMaterial() {
        return stringMaterial;
    }

    public void setStringMaterial(Material stringMaterial) {
        this.stringMaterial = stringMaterial;
    }

    public int getLengthInch() {
        return lengthInch;
    }

    public void setLengthInch(int lengthInch) {
        this.lengthInch = lengthInch;
    }

    public String getStringColor() {
        return stringColor;
    }

    public void setStringColor(String stringColor) {
        this.stringColor = stringColor;
    }

    public StringWireCategory getStringCategory() {
        return stringCategory;
    }

    public void setStringCategory(StringWireCategory stringCategory) {
        this.stringCategory = stringCategory;
    }

    @Override
    public void setAutoPrice() {
        this.price = 10;
    }

    @Override
    public String toString(){
        return description;
    }
}
