package com.beadinventory.beadinventory.REST.Domain.FinishedPieces;

import com.beadinventory.beadinventory.REST.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.REST.Domain.Supplies.Finding;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "EARRINGS")
public class Earrings extends AllFinishedPieces implements Serializable {

    @Column(name = "STERLING_SILVER")
    private boolean sterlingSilverYorN;

    public Earrings(){}

    public Earrings(String jpgName){
        super(jpgName);
    }

    public Earrings(HashMap<Bead, Integer> beads, HashMap<Finding, Integer> findings, double price, String description, boolean sterlingSilverYorN,
                    boolean isArchived, String jpgName) {
        super(beads, findings, price, description, isArchived,jpgName);
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

    @Override
    public String toString() {
        String sterling = (sterlingSilverYorN)? "Sterling Silver earwires": "earwires are not Sterling Silver";
        return description + "\n" + sterling;
    }
}
