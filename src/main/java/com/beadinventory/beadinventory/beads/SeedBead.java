package com.beadinventory.beadinventory.beads;

import com.beadinventory.beadinventory.beadCharacteristics.Material;
import com.beadinventory.beadinventory.beadCharacteristics.SeedBeedShape;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class SeedBead extends Bead {


    @Enumerated(EnumType.STRING)
    @Column(name = "SHAPE")
    private SeedBeedShape shape;



    public SeedBead(Material material, String color, String quality, long quantity, SeedBeedShape shape){
        super(material, color, quality, quantity);
        this.shape = shape;


    }
}
