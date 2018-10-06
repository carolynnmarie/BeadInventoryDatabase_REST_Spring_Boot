package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.StringingMaterial;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;

import javax.persistence.*;
import java.util.LinkedHashMap;

@Entity
@Table(name = "BOOKMARK")
public class Bookmark extends AllFinishedPieces {

    @Enumerated(value = EnumType.STRING)
    @Column(name = "STRING_MATERIAL")
    private Material stringMaterial;

    @Column(name = "STRING_COLOR")
    private String stringColor;

    public Bookmark(LinkedHashMap<Bead, Integer> beads, int hoursSpent, double difficultyLevel, double price, boolean hasSwarovski,
                    boolean hasNaturalStones, String description, Material stringMaterial, String stringColor) {
        super(beads, hoursSpent, difficultyLevel, price, hasSwarovski, hasNaturalStones, description);
        this.stringMaterial = stringMaterial;
        this.stringColor = stringColor;
    }

    public Material getStringMaterial() {
        return stringMaterial;
    }

    public void setStringMaterial(Material stringMaterial) {
        this.stringMaterial = stringMaterial;
    }

    public String getStringColor() {
        return stringColor;
    }

    public void setStringColor(String stringColor) {
        this.stringColor = stringColor;
    }

    @Override
    public void setAutoPrice() {

    }
}
