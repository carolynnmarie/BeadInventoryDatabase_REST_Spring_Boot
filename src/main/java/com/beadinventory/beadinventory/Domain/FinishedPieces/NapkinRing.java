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

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "COLOR_SCHEME")
    private String colorScheme;

    public NapkinRing(){}

    public NapkinRing(LinkedHashMap<Bead, Integer> beads, StringingMaterial stringingMaterial, LinkedHashMap<Finding, Integer> findings,
                      double price, String description, int quantity, String colorScheme) {
        super(beads, findings, price, description);
        this.stringingMaterial = stringingMaterial;
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
