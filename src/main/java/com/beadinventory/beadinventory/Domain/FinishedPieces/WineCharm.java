package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;

import javax.persistence.*;
import java.util.LinkedHashMap;

@Entity
@Table(name = "WINE_CHARM")
public class WineCharm extends AllFinishedPieces {

    @Column(name = "QUANTITY")
    private int quantity;

    public WineCharm(){}

    public WineCharm(LinkedHashMap<Bead, Integer> beads, LinkedHashMap<Finding, Integer> findings, double price, String description,
                     int quantity) {
        super(beads, findings, price, description);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void setAutoPrice() {
        price = (quantity == 4)? 16: (quantity == 6)? 23: Math.round(quantity*3.75);
    }

}
