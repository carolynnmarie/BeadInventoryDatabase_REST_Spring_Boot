package com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums;

public enum MaterialCategory {

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

