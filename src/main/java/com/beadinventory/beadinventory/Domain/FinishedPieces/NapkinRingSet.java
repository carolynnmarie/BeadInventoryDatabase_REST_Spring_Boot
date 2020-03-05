package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Serializers.*;
import com.beadinventory.beadinventory.Domain.Supplies.*;
import com.fasterxml.jackson.databind.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "NAPKIN_RING")
public class NapkinRingSet extends AllFinishedPieces implements Serializable {

    @JsonDeserialize(keyUsing = StringWireDeserializer.class)
    @JsonSerialize(keyUsing = StringWireSerializer.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STRING_WIRE_ID", updatable = false)
    private StringWire stringWire;

    @Column(name = "COLOR_SCHEME")
    private String colorScheme;

    @Column(name = "QUANTITY")
    private int quantity;

    public NapkinRingSet(){}

    public NapkinRingSet(HashMap<Bead, Integer> beads, HashMap<Finding, Integer> findings, double price, String description,
                         StringWire stringWire, String colorScheme, int quantity) {
        super(beads, findings, price, description);
        this.stringWire = stringWire;
        this.colorScheme = colorScheme;
        this.quantity = quantity;

    }

    public StringWire getStringWire() {
        return stringWire;
    }

    public void setStringWire(StringWire stringWire) {
        this.stringWire = stringWire;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColorScheme() {
        return colorScheme;
    }

    public void setColorScheme(String colorScheme) {
        this.colorScheme = colorScheme;
    }

    @Override
    public void setAutoPrice() {
        price = (quantity == 4)?20:(quantity == 6)?29: Math.round(quantity*4.75);
    }

    @Override
    public String toString(){
        return description + "Quantity: " + quantity;
    }

}
