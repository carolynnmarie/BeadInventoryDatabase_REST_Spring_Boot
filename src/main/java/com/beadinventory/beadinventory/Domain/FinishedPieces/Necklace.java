package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.StringWire;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
@Table(name = "NECKLACE")
public class Necklace extends AllFinishedPieces {


    @Column(name = "STRINGING_MATERIAL")
    private StringWire stringWire;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "STRINGING_MATERIAL_CATEGORY")
    private StringWireCategory stringWireCategory;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "CLASP")
    private FindingCategory clasp;

    @Column(name = "HAS_SWAROVSKI")
    protected boolean hasSwarovski;

    @Column(name = "HAS_NATURAL_STONES")
    protected boolean hasNaturalStones;

    @Column(name = "HOURS_SPENT")
    protected int hoursSpent;

    @Column(name = "DIFFICULTY_LEVEL")
    protected double difficultyLevel;

    @Column(name = "LENGTH")
    private double lengthInch;

    public Necklace(){}

    public Necklace(LinkedHashMap<Bead, Integer> beads, StringWire stringWire, LinkedHashMap<Finding, Integer> findings,
                    double lengthInch, int hoursSpent, double difficultyLevel, String description, boolean hasNaturalStones,
                    boolean hasSwarovski, double price, FindingCategory clasp) {
        super(beads, findings, price,  description);
        this.stringWire = stringWire;
        this.lengthInch = lengthInch;
        this.clasp = clasp;
        this.hasSwarovski = hasSwarovski;
        this.hasNaturalStones = hasNaturalStones;
        this.stringWireCategory = stringWire.getStringWireCategory();
        this.hoursSpent = hoursSpent;
        this.difficultyLevel =  difficultyLevel;
    }

    public StringWire getStringWire() {
        return stringWire;
    }

    public void setStringWire(StringWire stringWire) {
        this.stringWire = stringWire;
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

    public double getLengthInch() {
        return lengthInch;
    }

    public void setLengthInch(double lengthInch) {
        this.lengthInch = lengthInch;
    }

    public String getClaspString(){
        return clasp.toString();
    }

    public FindingCategory getClasp() {
        return clasp;
    }

    public void setClasp(FindingCategory clasp) {
        this.clasp = clasp;
    }

    public StringWireCategory getStringWireCategory() {
        return stringWireCategory;
    }

    public void setStringWireCategory(StringWireCategory stringWireCategory) {
        this.stringWireCategory = stringWireCategory;
    }

    public String describeNecklace(){
        String description = "The necklace is " + lengthInch + " inches long, on " + stringWire + ", with a " + getClaspString() + " clasp";
        description += (hasNaturalStones)?", with natural stone beads":"";
        description += (hasSwarovski)?", with Swarovski crystals":"";
        return description;
    }

    public boolean isHasSwarovski() { return hasSwarovski; }

    public void setHasSwarovski(boolean hasSwarovski) {
        this.hasSwarovski = hasSwarovski;
    }

    public boolean isHasNaturalStones() {
        return hasNaturalStones;
    }

    public void setHasNaturalStones(boolean hasNaturalStones) {
        this.hasNaturalStones = hasNaturalStones;
    }

    @Override
    public void setAutoPrice() {
        double beadPrice = 0.0;
        for(Map.Entry<Bead,Integer> entry: beads.entrySet()){
            beadPrice += (entry.getKey().getPricePoint()*entry.getValue());
        }
        double stringPrice = stringWire.getPricePerFoot()*lengthInch;
        double findingPrice = 0.0;
        for(Map.Entry<Finding,Integer> entry: findings.entrySet()){
            findingPrice += (entry.getKey().getPricePoint()*entry.getValue());
        }
        this.price = beadPrice + stringPrice + findingPrice + (hoursSpent*8)*difficultyLevel;
        if(hasSwarovski) price += 5;
        if(hasNaturalStones) price += 5;
    }

}
