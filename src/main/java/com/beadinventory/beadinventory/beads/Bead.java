package com.beadinventory.beadinventory.beads;


import com.beadinventory.beadinventory.beadCharacteristics.Material;
import com.beadinventory.beadinventory.beadCharacteristics.Shape;

import javax.persistence.*;

@Entity
public abstract class Bead {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "MATERIAL")
    private Material material;

    @Column(name = "COLOR")
    private String color;



    @Column(name = "QUALITY")
    private String quality;

    @Column(name = "QUANTITY")
    private long quantity;

    public Bead(){
        this.material = null;
        this.color = "";
        this.quality = "";
        this.quantity = 0;
    }

    public Bead(Material material, String color, String quality, long quantity) {
        this.material = material;
        this.color = color;
        this.quality = quality;
        this.quantity = quantity;
    }

}
