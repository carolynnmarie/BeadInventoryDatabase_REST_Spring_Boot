package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Serializers.StringWireDeserializer;
import com.beadinventory.beadinventory.Domain.Serializers.StringWireSerializer;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.StringWire;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "NECKLACE")
public class Necklace extends AllFinishedPieces implements Serializable {

    @JsonDeserialize(keyUsing = StringWireDeserializer.class)
    @JsonSerialize(keyUsing = StringWireSerializer.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STRING_WIRE_ID", updatable = false)
    private StringWire stringWire;

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

    public Necklace(HashMap<Bead, Integer> beads, HashMap<Finding, Integer> findings, StringWire stringWire, double lengthInch, int hoursSpent,
                    double difficultyLevel, String description, boolean hasNaturalStones, boolean hasSwarovski, double price,
                    FindingCategory clasp) {
        super(beads, findings, price,  description);
        this.stringWire = stringWire;
        this.lengthInch = lengthInch;
        this.clasp = clasp;
        this.hasSwarovski = hasSwarovski;
        this.hasNaturalStones = hasNaturalStones;
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

    public FindingCategory getClasp() {
        return clasp;
    }

    public void setClasp(FindingCategory clasp) {
        this.clasp = clasp;
    }

    public boolean getHasSwarovski() {
        return hasSwarovski;
    }

    public void setHasSwarovski(boolean hasSwarovski) {
        this.hasSwarovski = hasSwarovski;
    }

    public boolean getHasNaturalStones() {
        return hasNaturalStones;
    }

    public void setHasNaturalStones(boolean hasNaturalStones) {
        this.hasNaturalStones = hasNaturalStones;
    }

    public String describeNecklace(){
        String description = "The necklace is " + getLengthInch() + " inches long, on " + getStringWire().getStringWireCategory().toString()
                + ", with a " + clasp.toString();
        description += (getHasNaturalStones())?", with natural stone beads":"";
        description += (getHasSwarovski())?", with Swarovski crystals":"";
        return description;
    }

    @Override
    public void setAutoPrice() {
        double beadPrice = 0.0;
        double findingPrice = 0.0;
        double stringPrice = stringWire.getPricePerFoot()*lengthInch;
//        for(FPBeads bead: beads){
//            beadPrice += bead.getQuantity()*bead.getBeadOnItem().getPricePoint();
//        }
        for(Map.Entry<Bead,Integer> bead: beads.entrySet()){
            beadPrice += (bead.getKey().getPricePoint()*bead.getValue());
        }
        for(Map.Entry<Finding,Integer> finding: findings.entrySet()){
            findingPrice += (finding.getKey().getPricePoint()*finding.getValue());
        }
        this.price = beadPrice + stringPrice + findingPrice + (hoursSpent*8)*difficultyLevel;
        if(getHasSwarovski()) price += 5;
        if(getHasNaturalStones()) price += 5;
        price = Math.ceil(price);
    }

}
