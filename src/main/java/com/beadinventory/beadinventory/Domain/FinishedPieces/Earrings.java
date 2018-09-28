package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.*;


import javax.persistence.*;
import java.util.LinkedHashMap;

@Entity
public class Earrings extends AllFinishedPieces {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "EARRINGS_ID")
    private long id;


    @Column(name = "FINDINGS")
    private LinkedHashMap<Finding, Integer> findings;


    public Earrings(LinkedHashMap<Bead, Integer> beads, LinkedHashMap<Finding, Integer> findings, int hoursSpent,
                    double difficultyLevel, double price, boolean hasSwarovski, boolean hasNaturalStones, String description) {
        super(beads, hoursSpent, difficultyLevel, price, hasSwarovski, hasNaturalStones, description);
        this.findings = findings;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
