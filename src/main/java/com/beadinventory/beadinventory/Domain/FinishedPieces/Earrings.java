package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;


import javax.persistence.*;
import java.util.LinkedHashMap;

@Entity
@Table(name = "EARRINGS")
public class Earrings extends AllFinishedPieces {

    @Column(name = "STERLING_SILVER")
    private boolean sterlingSilverYorN;

    public Earrings(){}

    public Earrings(LinkedHashMap<Bead, Integer> beads, LinkedHashMap<Finding, Integer> findings, double price, String description,
                    boolean sterlingSilverYorN) {
        super(beads, findings, price, description);
        this.sterlingSilverYorN = sterlingSilverYorN;
    }

    public boolean getSterlingSilverYorN() {
        return sterlingSilverYorN;
    }

    public void setSterlingSilverYorN(boolean sterlingSilverYorN) {
        this.sterlingSilverYorN = sterlingSilverYorN;
    }

    @Override
    public void setAutoPrice() {
        this.price = (sterlingSilverYorN)?18:15;
    }
}
