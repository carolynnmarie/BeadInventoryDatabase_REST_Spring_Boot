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

    @Column(name = "HAS_SWAROVSKI")
    private boolean hasSwarovski;

    @Column(name = "HAS_NATURAL_STONES")
    private boolean hasNaturalStones;

    @Column(name = "LENGTH")
    private int lengthInch;


    public Bracelet(){}

    public Bracelet(LinkedHashMap<Bead, Integer> beads,LinkedHashMap<Finding, Integer> findings, double price, String description,
                    BraceletType braceletType, StringWire stringWire, boolean hasSwarovski, boolean hasNaturalStones, int lengthInch){
        super(beads, findings, price, description);
        this.braceletType = braceletType;
        this.stringWire = stringWire;
        this.hasSwarovski = hasSwarovski;
        this.hasNaturalStones = hasNaturalStones;
        this.lengthInch = lengthInch;
    }


    public StringWire getStringWire() {
        return stringWire;
    }

    public void setStringWire(StringWire stringWire) {
        this.stringWire = stringWire;
    }

    public BraceletType getBraceletType() {
        return braceletType;
    }

    public void setBraceletType(BraceletType braceletType) {
        this.braceletType = braceletType;
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

    public int getLengthInch() {
        return lengthInch;
    }

    public void setLengthInch(int lengthInch) {
        this.lengthInch = lengthInch;
    }

    @Override
    public void setAutoPrice() {
        this.price = (getBraceletType().equals(CHILD)||getBraceletType().equals(MEDICAL))?15:18;
        price += (getHasSwarovski() || getHasNaturalStones())? 2:0;
    }

}
