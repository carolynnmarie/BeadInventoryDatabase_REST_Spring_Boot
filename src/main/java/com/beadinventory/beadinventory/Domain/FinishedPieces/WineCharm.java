package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.*;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.LinkedHashMap;

@Entity
public class WineCharm extends AllFinishedPieces {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "WINE_CHARM_ID")
    private int id;


    public WineCharm(LinkedHashMap<Bead, Integer> beads, int hoursSpent,
                     double difficultyLevel, double price, boolean hasSwarovski, boolean hasNaturalStones, String description) {
        super(beads, hoursSpent, difficultyLevel, price, hasSwarovski, hasNaturalStones, description);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setAutoPrice() {

    }

}
