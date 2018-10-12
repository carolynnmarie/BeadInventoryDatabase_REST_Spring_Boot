package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.StringWire;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import javax.persistence.*;
import java.util.LinkedHashMap;

import static com.beadinventory.beadinventory.Domain.FinishedPieces.BraceletType.*;


@Entity
@Table(name = "BRACELET")
public class Bracelet extends AllFinishedPieces {

    @Enumerated(value = EnumType.STRING)
    @Column(name = "BRACELET_TYPE")
    private BraceletType braceletType;

    @Column(name = "STRINGING_MATERIAL")
    private StringWire stringWire;

    @Column(name = "FINDINGS")
    private LinkedHashMap<Finding, Integer> findings;

    @Column(name = "HAS_SWAROVSKI")
    private boolean hasSwarovski;

    @Column(name = "HAS_NATURAL_STONES")
    private boolean hasNaturalStones;

    @Column(name = "LENGTH")
    private int lengthInch;

    @Column(name = "HOURS_SPENT")
    private int hoursSpent;

    @Column(name = "DIFFICULTY_LEVEL")
    private double difficultyLevel;



    public Bracelet(){}

    public Bracelet(LinkedHashMap<Bead, Integer> beads,  int hoursSpent, double difficultyLevel, double price, String description,
                    boolean hasNaturalStones, boolean hasSwarovski,BraceletType braceletType, StringWire stringWire,
                    LinkedHashMap<Finding, Integer> findings, int lengthInch) {
        super(beads, findings, price, description);
        this.braceletType = braceletType;
        this.stringWire = stringWire;
        this.hasSwarovski = hasSwarovski;
        this.hasNaturalStones = hasNaturalStones;
        this.hoursSpent = hoursSpent;
        this.difficultyLevel = difficultyLevel;
        this.lengthInch = lengthInch;
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

    public StringWire getStringWire() {
        return stringWire;
    }

    public void setStringWire(StringWire stringWire) {
        this.stringWire = stringWire;
    }

    public LinkedHashMap<Finding, Integer> getFindings() {
        return findings;
    }

    public void setFindings(LinkedHashMap<Finding, Integer> findings) {
        this.findings = findings;
    }

    public BraceletType getBraceletType() {
        return braceletType;
    }

    public void setBraceletType(BraceletType braceletType) {
        this.braceletType = braceletType;
    }

    public boolean isHasSwarovski() {
        return hasSwarovski;
    }

    public void setHasSwarovski(boolean hasSwarovski) {
        this.hasSwarovski = hasSwarovski;
    }

    public boolean isHasNaturalStones() {
        return hasNaturalStones;
    }

    public void setHasNaturalStones(boolean hasNaturalStones) {
        this.hasNaturalStones = hasNaturalStones;
    }

    public int getLengthInch() {
        return lengthInch;
    }

    public void setLengthInch(int lengthInch) {
        this.lengthInch = lengthInch;
    }

    @Override
    public void setAutoPrice() {
        this.price = (braceletType.equals(CHILD)||braceletType.equals(MEDICAL))?15:18;
        price += (hasSwarovski || hasNaturalStones)? 2:0;
    }

}
