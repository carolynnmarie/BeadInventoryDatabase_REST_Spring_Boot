package com.beadinventory.beadinventory.Domain.StoreLists;

import com.beadinventory.beadinventory.Domain.Serializers.*;
import com.beadinventory.beadinventory.Domain.Supplies.*;
import com.fasterxml.jackson.databind.annotation.*;

import javax.persistence.*;
import java.util.*;

public class GeneralStoreList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private long id;

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

    public GeneralStoreList(List<Bead> beads, List<Finding> findings, List<StringWire> stringWire, List<String> otherItems) {
        this.beads = beads;
        this.findings = findings;
        this.stringWire = stringWire;
        this.otherItems = otherItems;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
