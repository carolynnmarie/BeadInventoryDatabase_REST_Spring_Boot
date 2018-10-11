package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.StringingMaterial;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import javax.persistence.*;
import java.util.LinkedHashMap;

import static com.beadinventory.beadinventory.Domain.FinishedPieces.BraceletType.*;


@Entity
@Table(name = "BRACELET")
public class Bracelet extends AllFinishedPieces {

    @Column(name = "BRACELET_TYPE")
    private BraceletType braceletType;

    @Column(name = "STRINGING_MATERIAL")
    private StringingMaterial stringingMaterial;

    @Column(name = "FINDINGS")
    private LinkedHashMap<Finding, Integer> findings;

    @Column(name = "HAS_SWAROVSKI")
    private boolean hasSwarovski;

    @Column(name = "HAS_NATURAL_STONES")
    private boolean hasNaturalStones;

    @Column(name = "HOURS_SPENT")
    private int hoursSpent;

    @Column(name = "DIFFICULTY_LEVEL")
    private double difficultyLevel;

    @Column(name = "LENGTH")
    private double lengthInch;

    public Bracelet(){}

    public Bracelet(LinkedHashMap<Bead, Integer> beads,  int hoursSpent, double difficultyLevel, double price, String description,
                    boolean hasNaturalStones, boolean hasSwarovski,BraceletType braceletType, StringingMaterial stringingMaterial,
                    LinkedHashMap<Finding, Integer> findings, double lengthInch) {
        super(beads, findings, price, description);
        this.braceletType = braceletType;

        this.stringingMaterial = stringingMaterial;
        this.lengthInch = lengthInch;
        this.hasSwarovski = hasSwarovski;
        this.hasNaturalStones = hasNaturalStones;
        this.hoursSpent = hoursSpent;
        this.difficultyLevel = difficultyLevel;
    }

    public int getHoursSpent() {
        return hoursSpent;
    }

    public void setHoursSpent(int hoursSpent) {
        this.hoursSpent = hoursSpent;
    }

    public double getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(double difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
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
        this.price = (braceletType.equals(CHILD)||braceletType.equals(MEDICAL))?15:18;
        price += (hasSwarovski || hasNaturalStones)? 2:0;
    }

}
