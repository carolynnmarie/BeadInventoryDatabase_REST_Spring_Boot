package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "BOOKMARK")
public class Bookmark extends AllFinishedPieces {

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = Bead.class)
    @JoinTable(name = "BEAD_MAP", joinColumns = @JoinColumn(name = "ALL_ID"))
    @MapKeyClass(value = Bead.class)
    @MapKeyJoinColumn(name = "BEAD_ID")
    protected Map<Bead, Integer> beads;


    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = Finding.class)
    @JoinTable(name = "FINDING_MAP",joinColumns = @JoinColumn(name = "ALL_ID"))
    @MapKeyClass(value = Finding.class)
    @MapKeyJoinColumn(name = "FINDING_ID")
    protected Map<Finding, Integer> findings;

    @Lob
    @Enumerated(value = EnumType.STRING)
    @Column(name = "STRING_MATERIAL")
    private Material stringMaterial;

    @Column(name = "STRING_COLOR")
    private String stringColor;

    @Column(name = "LENGTH")
    private int lengthInch;


    public Bookmark(){}

    public Bookmark(Map<Bead, Integer> beads, Map<Finding, Integer> findings, double price, String description,
                    Material stringMaterial, String stringColor, int lengthInch) {
        super(beads, findings, price, description);
        this.stringMaterial = stringMaterial;
        this.lengthInch = lengthInch;
        this.stringColor = stringColor;
    }

    public Material getStringMaterial() {
        return stringMaterial;
    }

    public void setStringMaterial(Material stringMaterial) {
        this.stringMaterial = stringMaterial;
    }

    public int getLengthInch() {
        return lengthInch;
    }

    public void setLengthInch(int lengthInch) {
        this.lengthInch = lengthInch;
    }

    public String getStringColor() {
        return stringColor;
    }

    public void setStringColor(String stringColor) {
        this.stringColor = stringColor;
    }

    @Override
    public void setAutoPrice() {
        this.price = 10;
    }
}
