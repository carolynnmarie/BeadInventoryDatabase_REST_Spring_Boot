package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;

import javax.persistence.*;
import java.util.LinkedHashMap;

@Entity
@Table(name = "BOOKMARK")
public class Bookmark extends AllFinishedPieces {

    @Enumerated(value = EnumType.STRING)
    @Column(name = "STRING_MATERIAL")
    private Material stringMaterial;

    @Column(name = "COLOR_SCHEME")
    private String colorScheme;

    @Column(name = "BEAD_COLOR")
    private String beadColor;

    public Bookmark(){}

    public Bookmark(LinkedHashMap<Bead, Integer> beads, int hoursSpent, double difficultyLevel, double price, String description,
                    Material stringMaterial, String colorScheme, String beadColor) {
        super(beads, hoursSpent, difficultyLevel, price, description);
        this.stringMaterial = stringMaterial;
        this.colorScheme = colorScheme;
        this.beadColor = beadColor;
    }

    public Material getStringMaterial() {
        return stringMaterial;
    }

    public void setStringMaterial(Material stringMaterial) {
        this.stringMaterial = stringMaterial;
    }

    public String getColorScheme() {
        return colorScheme;
    }

    public void setColorScheme(String colorScheme) {
        this.colorScheme = colorScheme;
    }

    public String getBeadColor() {
        return beadColor;
    }

    public void setBeadColor(String beadColor) {
        this.beadColor = beadColor;
    }

    @Override
    public void setAutoPrice() {
        this.price = 10;
    }
}
