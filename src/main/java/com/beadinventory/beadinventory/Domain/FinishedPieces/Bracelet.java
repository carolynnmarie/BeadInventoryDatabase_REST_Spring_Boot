package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.StringingMaterial;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;


import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
@Table(name = "BRACELET")
public class Bracelet extends AllFinishedPieces {

    @Column(name = "STRINGING_MATERIAL")
    private StringingMaterial stringingMaterial;

    @Column(name = "FINDINGS")
    private LinkedHashMap<Finding, Integer> findings;

    @Column(name = "LENGTH")
    private double lengthInch;


    public Bracelet(LinkedHashMap<Bead, Integer> beads,  int hoursSpent, double difficultyLevel, double price, String description, boolean hasNaturalStones,
                    boolean hasSwarovski,StringingMaterial stringingMaterial, LinkedHashMap<Finding, Integer> findings,
                    double lengthInch) {
        super(beads, hoursSpent, difficultyLevel, price, hasSwarovski, hasNaturalStones, description);
        this.findings = findings;
        this.stringingMaterial = stringingMaterial;
        this.lengthInch = lengthInch;
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

    public double getLengthInch() {
        return lengthInch;
    }

    public void setLengthInch(double lengthInch) {
        this.lengthInch = lengthInch;
    }


    @Override
    public void setAutoPrice() {
        double beadPrice = 0.0;
        for(Map.Entry<Bead,Integer> entry: beads.entrySet()){
            beadPrice += (entry.getKey().getPricePoint()*entry.getValue());
        }
        double stringPrice = stringingMaterial.getPricePerInch()*lengthInch;
        double findingPrice = 0.0;
        for(Map.Entry<Finding,Integer> entry: findings.entrySet()){
            findingPrice += (entry.getKey().getPricePoint()*entry.getValue());
        }
        this.price = beadPrice + stringPrice + findingPrice + (hoursSpent*8)*difficultyLevel;
        if(hasSwarovski) price += 7;
        if(hasNaturalStones) price += 5;
    }

}
