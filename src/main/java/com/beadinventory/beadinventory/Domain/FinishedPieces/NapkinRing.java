package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.*;


import javax.persistence.*;
import java.util.LinkedHashMap;

@Entity
public class NapkinRing extends AllFinishedPieces {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "NAPKIN_RING_ID")
    private long id;

    @Column(name = "STRINGING_MATERIAL")
    private StringingMaterial stringingMaterial;

    @Column(name = "FINDINGS")
    private LinkedHashMap<Finding, Integer> findings;


    public NapkinRing(LinkedHashMap<Bead, Integer> beads, StringingMaterial stringingMaterial, LinkedHashMap<Finding, Integer> findings,
                      int hoursSpent, double difficultyLevel, double price, boolean hasSwarovski, boolean hasNaturalStones, String description, LinkedHashMap<Bead, Integer> beads1, StringingMaterial stringingMaterial1, LinkedHashMap<Finding, Integer> findings1, int hoursSpent1, double difficultyLevel1, double price1, boolean hasSwarovski1, boolean hasNaturalStones1, String description1) {
        super(beads, hoursSpent, difficultyLevel, price, hasSwarovski, hasNaturalStones, description);
        this.stringingMaterial = stringingMaterial;
        this.findings = findings;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public void setAutoPrice() {

    }
}
