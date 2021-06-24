package com.beadinventory.beadinventory.REST.Domain.FinishedPieces;

import java.io.Serializable;

public enum BraceletType implements Serializable {

    MEDICAL,
    ELASTIC,
    CHILD,
    NORMAL;

    @Override
    public String toString(){
        return name().toLowerCase();
    }
}
