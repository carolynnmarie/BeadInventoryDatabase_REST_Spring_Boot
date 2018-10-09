package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;

import javax.persistence.*;
import java.util.LinkedHashMap;

@Entity
@Table(name = "WINE_CHARM")
public class WineCharm extends AllFinishedPieces {

    @Column(name = "QUANTITY")
    private int quantity;

    public WineCharm(){}

    public WineCharm(LinkedHashMap<Bead, Integer> beads, int hoursSpent, double difficultyLevel, double price, boolean hasSwarovski,
                     boolean hasNaturalStones, String description, int quantity) {
        super(beads, hoursSpent, difficultyLevel, price, hasSwarovski, hasNaturalStones, description);
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
        if(quantity == 4){
            price = 16;
        } else if(quantity == 6){
            price = 23;
        } else{
            price = quantity*3.75;
        }
    }

}
