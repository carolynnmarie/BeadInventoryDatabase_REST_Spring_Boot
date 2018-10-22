package com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums;

import java.io.Serializable;

public enum MaterialCategory implements Serializable {

    NATURAL_STONE,
    SEMI_PRECIOUS_STONE,
    METAL,
    PRECIOUS_METAL,
    GLASS,
    SEED,
    OTHER,
    STRINGING;


    MaterialCategory(){ }

    @Override
    public String toString() {
        return name().toLowerCase().replace('_',' ');
    }
}

