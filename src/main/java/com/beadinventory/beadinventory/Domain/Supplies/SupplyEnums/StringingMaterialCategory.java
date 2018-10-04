package com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.MaterialCategory.STRINGING;

public enum StringingMaterialCategory {
    BEADING_WIRE("beading wire"),
    BEADING_THREAD("beading thread"),
    WAXED_COTTON("waxed cotton cord"),
    ELASTIC("elastic"),
    STRETCHY_FILAMENT("stretchy filament"),
    NON_STRETCHY_FILAMENT("non-stretchy filament"),
    HEMP("hemp cord"),
    FAUX_SUEDE("faux-suede cord"),
    LEATHER_SUEDE("leather cord"),
    CHAIN("chain"),
    WRAPPING_WIRE("bead wrapping wire"),
    MEMORY_WIRE("memory wire");

    private String mCategory;

    StringingMaterialCategory(String mCategory){
        this.mCategory = mCategory;
    }

    @Override
    public String toString(){
        return mCategory;
    }
}
