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

    public NapkinRing(LinkedHashMap<Bead, Integer> beads, LinkedHashMap<Finding, Integer> findings, double price, String description,
                      StringWire stringWire, String colorScheme, int quantity) {
        super(beads, findings, price, description);
        this.stringWire = stringWire;
        this.colorScheme = colorScheme;
        this.quantity = quantity;
    }

    public StringWire getStringWire() {
        return stringWire;
    }

    public void setStringWire(StringWire stringWire) {
        this.stringWire = stringWire;
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
            price = Math.round(quantity*4.75);
        }
    }
}
