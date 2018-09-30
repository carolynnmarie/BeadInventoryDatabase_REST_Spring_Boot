package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;

import javax.persistence.*;
import java.util.LinkedHashMap;

@Entity
@Table(name = "WINE_CHARM")
public class WineCharm extends AllFinishedPieces {


    public WineCharm(LinkedHashMap<Bead, Integer> beads, int hoursSpent,
                     double difficultyLevel, double price, boolean hasSwarovski, boolean hasNaturalStones, String description) {
        super(beads, hoursSpent, difficultyLevel, price, hasSwarovski, hasNaturalStones, description);
    }

    @Override
    public void setAutoPrice() {

    }

}
