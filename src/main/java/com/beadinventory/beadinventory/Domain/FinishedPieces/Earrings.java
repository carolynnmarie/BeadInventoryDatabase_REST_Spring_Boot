package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;


import javax.persistence.*;
import java.util.LinkedHashMap;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.FULL_STERLING_SILVER;

@Entity
@Table(name = "EARRINGS")
public class Earrings extends AllFinishedPieces {

    @Column(name = "IS_EARWIRE_STERLING_SILVER")
    private boolean isSterlingSilver;

    public Earrings(){}

    public Earrings(LinkedHashMap<Bead, Integer> beads, double price, String description, LinkedHashMap<Finding, Integer> findings,
                    boolean isSterlingSilver) {
        super(beads, findings, price, description);
        this.isSterlingSilver = isSterlingSilver;
    }

    public LinkedHashMap<Finding, Integer> getFindings() {
        return findings;
    }

    public void setFindings(LinkedHashMap<Finding, Integer> findings) {
        this.findings = findings;
    }

    public boolean isSterlingSilver() {
        return isSterlingSilver;
    }

    public void setSterlingSilver(boolean sterlingSilver) {
        isSterlingSilver = sterlingSilver;
    }

    @Override
    public void setAutoPrice() {
        this.price = (isSterlingSilver)?18:15;
    }
}
