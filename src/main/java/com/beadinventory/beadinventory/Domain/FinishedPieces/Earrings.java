package com.beadinventory.beadinventory.Domain.FinishedPieces;


import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "EARRINGS")
public class Earrings extends AllFinishedPieces implements Serializable {

    @Column(name = "STERLING_SILVER")
    private boolean sterlingSilverYorN;

    public Earrings(){}

    public Earrings(HashMap<Bead, Integer> beads, HashMap<Finding, Integer> findings, double price, String description, boolean sterlingSilverYorN) {
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
