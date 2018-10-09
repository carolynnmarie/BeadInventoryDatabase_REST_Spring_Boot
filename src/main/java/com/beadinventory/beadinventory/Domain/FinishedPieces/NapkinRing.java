package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.StringingMaterial;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;

import javax.persistence.*;
import java.util.LinkedHashMap;

@Entity
@Table(name = "NAPKIN_RING")
public class NapkinRing extends AllFinishedPieces {


    @Column(name = "STRINGING_MATERIAL")
    private StringingMaterial stringingMaterial;

    @Column(name = "FINDINGS")
    private LinkedHashMap<Finding, Integer> findings;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "COLOR_SCHEME")
    private String colorScheme;

    public NapkinRing(){}

    public NapkinRing(LinkedHashMap<Bead, Integer> beads, StringingMaterial stringingMaterial, LinkedHashMap<Finding, Integer> findings,
                      int hoursSpent, double difficultyLevel, double price, boolean hasSwarovski, boolean hasNaturalStones, String description,
                      int quantity, String colorScheme) {
        super(beads, hoursSpent, difficultyLevel, price, hasSwarovski, hasNaturalStones, description);
        this.stringingMaterial = stringingMaterial;
        this.findings = findings;
        this.quantity = quantity;
        this.colorScheme = colorScheme;
    }

    public StringingMaterial getStringingMaterial() {
        return stringingMaterial;
    }

    public void setStringingMaterial(StringingMaterial stringingMaterial) {
        this.stringingMaterial = stringingMaterial;
    }

    public LinkedHashMap<Finding, Integer> getFindings() {
        return findings;
    }

    public void setFindings(LinkedHashMap<Finding, Integer> findings) {
        this.findings = findings;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColorScheme() {
        return colorScheme;
    }

    public void setColorScheme(String colorScheme) {
        this.colorScheme = colorScheme;
    }

    @Override
    public void setAutoPrice() {
        if(quantity == 4){
            price = 20;
        } else if(quantity == 6){
            price = 29;
        } else {
            price = quantity*4.75;
        }
    }
}
