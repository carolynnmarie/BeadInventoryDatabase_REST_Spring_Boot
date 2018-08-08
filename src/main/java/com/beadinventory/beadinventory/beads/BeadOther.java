package com.beadinventory.beadinventory.beads;


import com.beadinventory.beadinventory.beadCharacteristics.Material;
import com.beadinventory.beadinventory.beadCharacteristics.Shape;

import javax.persistence.*;

@Entity
public class BeadOther extends Bead {

    @Column(name = "SIZE_CM")
    private int sizeCM;

    @Enumerated(EnumType.STRING)
    @Column(name = "SHAPE")
    private Shape shape;

    @Column(name = "DESCRIPTION")
    private String description;

    public BeadOther(Material material, String color, int sizeCM, Shape shape, String description, String quality, long quantity) {
        super(material, color, quality, quantity);
        this.sizeCM = sizeCM;
        this.shape = shape;
        this.description = description;
    }
}

