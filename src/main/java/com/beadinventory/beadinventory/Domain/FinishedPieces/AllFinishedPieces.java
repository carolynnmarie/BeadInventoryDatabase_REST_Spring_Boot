package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import javafx.beans.DefaultProperty;

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

    @Column(name = "FINDINGS")
    protected LinkedHashMap<Finding, Integer> findings;

    @Column(name = "PRICE")
    protected double price;

    @Column(name = "DESCRIPTION")
    protected String description;

    public AllFinishedPieces() {
    }

    public AllFinishedPieces(LinkedHashMap<Bead, Integer> beads, LinkedHashMap<Finding,Integer> findings,  double price, String description) {
        this.beads = beads;
        this.findings = findings;
        this.price = price;
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
