package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;

import javax.persistence.Id;
import javax.persistence.*;
import java.util.LinkedHashMap;


@MappedSuperclass
public abstract class AllFinishedPieces {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "BEADS")
    protected LinkedHashMap<Bead,Integer> beads;

    @Column(name = "HOURS_SPENT")
    protected int hoursSpent;

    @Column(name = "DIFFICULTY_LEVEL")
    protected double difficultyLevel;

    @Column(name = "PRICE")
    protected double price;

    @Column(name = "HAS_SWAROVSKI")
    protected boolean hasSwarovski;

    @Column(name = "HAS_NATURAL_STONES")
    protected boolean hasNaturalStones;

    @Column(name = "DESCRIPTION")
    protected String description;

    public AllFinishedPieces() {
    }

    public AllFinishedPieces(LinkedHashMap<Bead, Integer> beads, int hoursSpent, double difficultyLevel, double price,
                             boolean hasSwarovski, boolean hasNaturalStones, String description) {
        this.beads = beads;
        this.hoursSpent = hoursSpent;
        this.difficultyLevel = difficultyLevel;
        this.price = price;
        this.hasSwarovski = hasSwarovski;
        this.hasNaturalStones = hasNaturalStones;
        this.description = description;
    }

    public LinkedHashMap<Bead, Integer> getBeads() {
        return beads;
    }

    public void setBeads(LinkedHashMap<Bead, Integer> beads) {
        this.beads = beads;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId(){
        return id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isHasSwarovski() {
        return hasSwarovski;
    }

    public void setHasSwarovski(boolean hasSwarovski) {
        this.hasSwarovski = hasSwarovski;
    }

    public boolean isHasNaturalStones() {
        return hasNaturalStones;
    }

    public void setHasNaturalStones(boolean hasNaturalStones) {
        this.hasNaturalStones = hasNaturalStones;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract void setAutoPrice();
}
