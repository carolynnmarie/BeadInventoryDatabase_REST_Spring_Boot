package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import javafx.beans.DefaultProperty;

import javax.persistence.Id;
import javax.persistence.*;
import java.util.HashMap;
import java.util.LinkedHashMap;


@MappedSuperclass
public abstract class AllFinishedPieces {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Lob
    @Column(name = "BEADS")
    protected HashMap<Bead,Integer> beads;

    @Lob
    @Column(name = "FINDINGS")
    protected HashMap<Finding, Integer> findings;

    @Column(name = "PRICE")
    protected double price;

    @Column(name = "DESCRIPTION")
    protected String description;

    public AllFinishedPieces() {
    }

    public AllFinishedPieces(HashMap<Bead, Integer> beads, HashMap<Finding,Integer> findings,  double price, String description) {
        this.beads = beads;
        this.findings = findings;
        this.price = price;
        this.description = description;
    }

    public HashMap<Bead, Integer> getBeads() {
        return beads;
    }

    public void setBeads(HashMap<Bead, Integer> beads) {
        this.beads = beads;
    }

    public HashMap<Finding, Integer> getFindings() {
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
