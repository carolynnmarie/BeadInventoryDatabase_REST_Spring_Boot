package com.beadinventory.beadinventory.Domain;

import com.beadinventory.beadinventory.Domain.Serializers.*;
import com.beadinventory.beadinventory.Domain.Supplies.*;
import com.fasterxml.jackson.databind.annotation.*;

import javax.persistence.*;
import java.util.*;

public class StoreList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "TITLE")
    private String projectTitle;

    @JsonSerialize(keyUsing = BeadSerializer.class)
    @JsonDeserialize(keyUsing = BeadDeserializer.class)
    @OneToMany
    @Column(name = "BEADS")
    private List<Bead> beads;

    @JsonSerialize(keyUsing = FindingSerializer.class)
    @JsonDeserialize(keyUsing = FindingDeserializer.class)
    @OneToMany
    @Column(name = "FINDINGS")
    private List<Finding> findings;

    @JsonDeserialize(keyUsing = StringWireDeserializer.class)
    @JsonSerialize(keyUsing = StringWireSerializer.class)
    @OneToMany
    @Column(name = "STRINGING")
    private List<StringWire> stringWire;

    @ElementCollection
    @Column(name = "OTHER_ITEMS")
    private List<String> otherItems;

    public StoreList(){}

    public StoreList(String projectTitle, List<Bead> beads, List<Finding> findings, List<StringWire> stringWire, List<String> otherItems) {
        this.projectTitle = projectTitle;
        this.beads = beads;
        this.findings = findings;
        this.stringWire = stringWire;
        this.otherItems = otherItems;
    }

    public StoreList(String projectTitle){
        this.projectTitle = projectTitle;
        this.beads = new ArrayList<>();
        this.findings = new ArrayList<>();
        this.stringWire = new ArrayList<>();
        this.otherItems = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public List<Bead> getBeads() {
        return beads;
    }

    public void setBeads(List<Bead> beads) {
        this.beads = beads;
    }

    public List<Finding> getFindings() {
        return findings;
    }

    public void setFindings(List<Finding> findings) {
        this.findings = findings;
    }

    public List<StringWire> getStringWire() {
        return stringWire;
    }

    public void setStringWire(List<StringWire> stringWire) {
        this.stringWire = stringWire;
    }

    public List<String> getOtherItems() {
        return otherItems;
    }

    public void setOtherItems(List<String> otherItems) {
        this.otherItems = otherItems;
    }
}
