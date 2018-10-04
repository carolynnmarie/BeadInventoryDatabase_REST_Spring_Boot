package com.beadinventory.beadinventory.Domain.FinishedPieces;

public enum BraceletType {
    MEDICAL,
    ELASTIC,
    CHILD,
    NORMAL;

    @Override
    public String toString(){
        return name().toLowerCase();
    }
}
