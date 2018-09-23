package com.beadinventory.beadinventory.Domain.beadCharacteristics;

public enum MaterialCategory {

    NATURAL_STONE,
    SEMI_PRECIOUS_STONE,
    METAL,
    PRECIOUS_METAL,
    GLASS,
    SEED,
    OTHER;


    MaterialCategory(){ }

    @Override
    public String toString() {
        return name().toLowerCase().replace('_',' ');
    }
}

