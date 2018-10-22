package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;

import javax.persistence.Id;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@MappedSuperclass
public abstract class AllFinishedPieces implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private long id;

    @ElementCollection
    @CollectionTable(name = "BEAD_MAP")
    @MapKeyJoinColumn(name = "BEAD_ID")
    @Column
    protected Map<Bead, Integer> beads;

    @ElementCollection
    @CollectionTable(name = "FINDING_MAP")
    @MapKeyJoinColumn(table = "FINDING", name = "FINDING_ID")
    @Column(name = "FINDINGS")
    protected Map<Finding, Integer> findings;

    @Column(name = "PRICE")
    protected double price;

    @Column(name = "DESCRIPTION")
    protected String description;

    public AllFinishedPieces() {
    }

    public AllFinishedPieces(Map<Bead, Integer> beads, Map<Finding, Integer> findings, double price, String description) {
        this.beads = beads;
        this.findings = findings;
        this.price = price;
        this.description = description;
    }

    public Map<Bead, Integer> getBeads() {
        return beads;
    }

    public void setBeads(HashMap<Bead, Integer> beads) {
        this.beads = beads;
    }

    public Map<Finding, Integer> getFindings() {
        return findings;
    }

    public void setFindings(HashMap<Finding, Integer> findings) {
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
