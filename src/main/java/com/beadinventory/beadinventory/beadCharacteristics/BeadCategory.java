package com.beadinventory.beadinventory.beadCharacteristics;

public enum BeadCategory {

    NATURAL_STONE("natural stone"),
    SEMI_PRECIOUS_STONE("semi-precious stone"),
    METAL("metal"),
    PRECIOUS_METAL("precious metal"),
    GLASS("glass"),
    OTHER("other"),
    SEED("seed)");

    String category;

    BeadCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return this.category;
    }
}
