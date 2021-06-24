package com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums;

import java.io.Serializable;

public enum StringWireCategory implements Serializable {
    BEADING_WIRE("beading wire"),
    BEADING_THREAD("beading thread"),
    ELASTIC("elastic"),
    STRETCHY_FILAMENT("stretchy filament"),
    NON_STRETCHY_FILAMENT("non-stretchy filament"),
    CORD("cord"),
    CHAIN("chain"),
    WRAPPING_WIRE("bead wrapping wire"),
    MEMORY_WIRE("memory wire");

    private String mCategory;

    StringWireCategory(String mCategory){
        this.mCategory = mCategory;
    }

    @Override
    public String toString(){
        return mCategory;
    }
}
