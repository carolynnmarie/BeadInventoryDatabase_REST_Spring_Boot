package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;

import javax.persistence.Id;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@MappedSuperclass
public abstract class AllFinishedPieces implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ALL_ID")
    private long id;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "BEAD_MAP", joinColumns = @JoinColumn(name = "ALL_ID"))
//    @MapKeyJoinColumn(name = "BEAD_ID")
    @Column
    protected Map<Bead, Integer> beads = new HashMap<>();


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "FINDING_MAP",joinColumns = @JoinColumn(name = "ALL_ID"))
//    @MapKeyJoinColumn(name = "FINDING_ID")
    @Column
    protected Map<Finding, Integer> findings = new HashMap<>();


    @Column(name = "PRICE")
    protected double price;

    @Column(name = "DESCRIPTION")
    protected String description;

    public AllFinishedPieces() {
    }

    public AllFinishedPieces(HashMap<Bead, Integer> beads, HashMap<Finding, Integer> findings, double price, String description) {
        this.beads = beads;
        this.findings = findings;
        this.price = price;
        this.description = description;
    }

    public Map<Bead, Integer> getBeads() {
        return beads;
    }

    public void setBeads(Map<Bead, Integer> beads) {
        this.beads = beads;
    }

    public Map<Finding, Integer> getFindings() {
        return findings;
    }

    public void setFindings(Map<Finding, Integer> findings) {
        this.findings = findings;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract void setAutoPrice();
}
