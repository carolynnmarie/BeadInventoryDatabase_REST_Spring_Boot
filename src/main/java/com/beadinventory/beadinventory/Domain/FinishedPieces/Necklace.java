package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.StringingMaterial;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
public class Necklace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "BEADS")
    private LinkedHashMap<Bead,Integer> beads;

    @Column(name = "STRINGING_MATERIAL")
    private StringingMaterial stringingMaterial;

    @Column(name = "FINDINGS")
    private LinkedHashMap<Finding, Integer> findings;

    @Column(name = "LENGTH")
    private double lengthInch;

    @Column(name = "HOURS_SPENT")
    private int hoursSpent;

    @Column(name = "DIFFICULTY_LEVEL")
    private double difficultyLevel;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "DESCRIPTION")
    private String description;

    public Necklace(LinkedHashMap<Bead, Integer> beads, StringingMaterial stringingMaterial, LinkedHashMap<Finding, Integer> findings,
                    double lengthInch, int hoursSpent, double difficultyLevel, String description) {
        this.beads = beads;
        this.stringingMaterial = stringingMaterial;
        this.findings = findings;
        this.lengthInch = lengthInch;
        this.hoursSpent = hoursSpent;
        this.difficultyLevel = difficultyLevel;
        this.description = description;
        double beadPrice = 0.0;
        for(Map.Entry<Bead,Integer> entry: beads.entrySet()){
            beadPrice += (entry.getKey().getPricePoint()*entry.getValue());
        }
        double stringPrice = stringingMaterial.getPricePerInch()*lengthInch;
        double findingPrice = 0.0;
        for(Map.Entry<Finding,Integer> entry: findings.entrySet()){
            findingPrice += (entry.getKey().getPricePoint()*entry.getValue());
        }
        this.price = beadPrice + stringPrice + findingPrice + (hoursSpent*8)*difficultyLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedHashMap<Bead, Integer> getBeads() {
        return beads;
    }

    public void setBeads(LinkedHashMap<Bead, Integer> beads) {
        this.beads = beads;
    }

    public StringingMaterial getStringingMaterial() {
        return stringingMaterial;
    }

    public void setStringingMaterial(StringingMaterial stringingMaterial) {
        this.stringingMaterial = stringingMaterial;
    }

    public LinkedHashMap<Finding, Integer> getFindings() {
        return findings;
    }

    public void setFindings(LinkedHashMap<Finding, Integer> findings) {
        this.findings = findings;
    }

    public double getLengthInch() {
        return lengthInch;
    }

    public void setLengthInch(double lengthInch) {
        this.lengthInch = lengthInch;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setAutoPrice() {
        double beadPrice = 0.0;
        for(Map.Entry<Bead,Integer> entry: beads.entrySet()){
            beadPrice += (entry.getKey().getPricePoint()*entry.getValue());
        }
        double stringPrice = stringingMaterial.getPricePerInch()*lengthInch;
        double findingPrice = 0.0;
        for(Map.Entry<Finding,Integer> entry: findings.entrySet()){
            findingPrice += (entry.getKey().getPricePoint()*entry.getValue());
        }
        this.price = beadPrice + stringPrice + findingPrice + (hoursSpent*8)*difficultyLevel;
    }
}
