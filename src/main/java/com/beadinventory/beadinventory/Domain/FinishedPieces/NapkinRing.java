package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.StringWire;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;

import javax.persistence.*;
import java.util.LinkedHashMap;

@Entity
@Table(name = "NAPKIN_RING")
public class NapkinRing extends AllFinishedPieces {


    @Column(name = "STRINGING_MATERIAL")
    private StringWire stringWire;

    @Column(name = "COLOR_SCHEME")
    private String colorScheme;

    @Column(name = "QUANTITY")
    private int quantity;


    public NapkinRing(){}

    public NapkinRing(LinkedHashMap<Bead, Integer> beads, LinkedHashMap<Finding, Integer> findings,
                      double price, String description, StringWire stringWire, int quantity, String colorScheme) {
        super(beads, findings, price, description);
        this.stringWire = stringWire;
        this.quantity = quantity;
        this.colorScheme = colorScheme;
    }

    public StringWire getStringWire() {
        return stringWire;
    }

    public void setStringWire(StringWire stringWire) {
        this.stringWire = stringWire;
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
