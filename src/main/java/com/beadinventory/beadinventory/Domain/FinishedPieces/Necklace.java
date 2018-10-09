package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.StringingMaterial;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringingMaterialCategory;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
@Table(name = "NECKLACE")
public class Necklace extends AllFinishedPieces {


    @Enumerated(value = EnumType.STRING)
    @Column(name = "CLASP")
    private FindingCategory clasp;

    @Column(name = "FINDINGS")
    protected LinkedHashMap<Finding, Integer> findings;

    @Column(name = "STRINGING_MATERIAL")
    private StringingMaterial stringingMaterial;

    @Column(name = "STRINGING_MATERIAL_CATEGORY")
    private StringingMaterialCategory stringingMaterialCategory;

    @Column(name = "LENGTH")
    private double lengthInch;

    public Necklace(){}

    public Necklace(LinkedHashMap<Bead, Integer> beads, StringingMaterial stringingMaterial, LinkedHashMap<Finding, Integer> findings,
                    double lengthInch, int hoursSpent, double difficultyLevel, String description, boolean hasNaturalStones,
                    boolean hasSwarovski, double price, FindingCategory clasp) {
        super(beads, hoursSpent, difficultyLevel, price, hasSwarovski, hasNaturalStones, description);
        this.findings = findings;
        this.stringingMaterial = stringingMaterial;
        this.lengthInch = lengthInch;
        this.clasp = clasp;
        this.stringingMaterialCategory = stringingMaterial.getsMCategory();
    }


    public LinkedHashMap<Finding, Integer> getFindings() {
        return findings;
    }

    public void setFindings(LinkedHashMap<Finding, Integer> findings) {
        this.findings = findings;
    }

    public StringingMaterial getStringingMaterial() {
        return stringingMaterial;
    }

    public void setStringingMaterial(StringingMaterial stringingMaterial) {
        this.stringingMaterial = stringingMaterial;
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

    public StringingMaterialCategory getStringingMaterialCategory() {
        return stringingMaterialCategory;
    }

    public void setStringingMaterialCategory(StringingMaterialCategory stringingMaterialCategory) {
        this.stringingMaterialCategory = stringingMaterialCategory;
    }

    public String describeNecklace(){
        String description = "The necklace is " + lengthInch + " inches long, on " + stringingMaterial + ", with a " + getClaspString();
        description += (hasNaturalStones)?", with natural stone beads":"";
        description += (hasSwarovski)?", with Swarovski crystals":"";
        return description;
    }


    @Override
    public void setAutoPrice() {
        double beadPrice = 0.0;
        for(Map.Entry<Bead,Integer> entry: beads.entrySet()){
            beadPrice += (entry.getKey().getPricePoint()*entry.getValue());
        }
        double stringPrice = stringingMaterial.getPricePerFoot()*lengthInch;
        double findingPrice = 0.0;
        for(Map.Entry<Finding,Integer> entry: findings.entrySet()){
            findingPrice += (entry.getKey().getPricePoint()*entry.getValue());
        }
        this.price = beadPrice + stringPrice + findingPrice + (hoursSpent*8)*difficultyLevel;
        if(hasSwarovski) price += 7;
        if(hasNaturalStones) price += 5;
    }

}
