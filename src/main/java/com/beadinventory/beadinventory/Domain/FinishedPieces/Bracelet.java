package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Serializers.*;
import com.beadinventory.beadinventory.Domain.Supplies.*;
import com.fasterxml.jackson.databind.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;

import static com.beadinventory.beadinventory.Domain.FinishedPieces.BraceletType.*;


@Entity
@Table(name = "BRACELET")
public class Bracelet extends AllFinishedPieces implements Serializable {

    @Enumerated(value = EnumType.STRING)
    @Column(name = "BRACELET_TYPE")
    private BraceletType braceletType;

    @JsonDeserialize(keyUsing = StringWireDeserializer.class)
    @JsonSerialize(keyUsing = StringWireSerializer.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STRING_WIRE_ID", updatable = false)
    private StringWire stringWire;

    @Column(name = "HAS_SWAROVSKI")
    private boolean hasSwarovski;

    @Column(name = "HAS_NATURAL_STONES")
    private boolean hasNaturalStones;

    @Column(name = "LENGTH")
    private int lengthInch;


    public Bracelet(){}

    public Bracelet(HashMap<Bead, Integer> beads, HashMap<Finding, Integer> findings, double price, String description, BraceletType braceletType,
                    StringWire stringWire, boolean hasNaturalStones, boolean hasSwarovski, int lengthInch){
        super(beads, findings, price, description);
        this.braceletType = braceletType;
        this.stringWire = stringWire;
        this.hasNaturalStones = hasNaturalStones;
        this.hasSwarovski = hasSwarovski;
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
