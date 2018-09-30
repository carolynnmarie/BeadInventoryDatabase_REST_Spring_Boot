package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;


import javax.persistence.*;
import java.util.LinkedHashMap;

@Entity
@Table(name = "EARRINGS")
public class Earrings extends AllFinishedPieces {


    @Column(name = "FINDINGS")
    private LinkedHashMap<Finding, Integer> findings;


    public Earrings(LinkedHashMap<Bead, Integer> beads, int hoursSpent,
                    double difficultyLevel, double price, boolean hasSwarovski, boolean hasNaturalStones, String description,LinkedHashMap<Finding, Integer> findings) {
        super(beads, hoursSpent, difficultyLevel, price, hasSwarovski, hasNaturalStones, description);
        this.findings = findings;
    }

    public LinkedHashMap<Finding, Integer> getFindings() {
        return findings;
    }

    public void setFindings(LinkedHashMap<Finding, Integer> findings) {
        this.findings = findings;
    }

    @Override
    public void setAutoPrice() {

    }
}
