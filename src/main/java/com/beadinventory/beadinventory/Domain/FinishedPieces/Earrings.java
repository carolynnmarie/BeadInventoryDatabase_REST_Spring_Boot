package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.MaterialCategory;


import javax.persistence.*;
import java.util.LinkedHashMap;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.FULL_STERLING_SILVER;

@Entity
@Table(name = "EARRINGS")
public class Earrings extends AllFinishedPieces {

    private Material wireMaterial;
    @Column(name = "EARWIRE_MATERIAL")
    public String getWireMaterial(){
        return wireMaterial.toString();
    }

    @Column(name = "FINDINGS")
    private LinkedHashMap<Finding, Integer> findings;


    public Earrings(LinkedHashMap<Bead, Integer> beads, int hoursSpent,
                    double difficultyLevel, double price, boolean hasSwarovski, boolean hasNaturalStones, String description,
                    LinkedHashMap<Finding, Integer> findings, Material wireMaterial) {
        super(beads, hoursSpent, difficultyLevel, price, hasSwarovski, hasNaturalStones, description);
        this.findings = findings;
        this.wireMaterial = wireMaterial;
    }

    public LinkedHashMap<Finding, Integer> getFindings() {
        return findings;
    }

    public void setFindings(LinkedHashMap<Finding, Integer> findings) {
        this.findings = findings;
    }

    public void setWireMaterial(Material wireMaterial) {
        this.wireMaterial = wireMaterial;
    }

    @Override
    public void setAutoPrice() {
        this.price = (wireMaterial.equals(FULL_STERLING_SILVER))?18:15;
    }
}
