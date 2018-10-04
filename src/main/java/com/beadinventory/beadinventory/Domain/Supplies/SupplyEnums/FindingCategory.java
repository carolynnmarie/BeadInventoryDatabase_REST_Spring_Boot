package com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums;


public enum FindingCategory {
    LOBSTER_CLASP,
    LOOP_AND_TOGGLE_CLASP,
    MAGNETIC_CLASP,
    THREADED_BARREL_CLASP,
    RING_CLASP,
    CARABINER,
    EAR_WIRE,
    EARRING_POST,
    EARRING_BACK,
    CRIMP_BEAD,
    SPRING_COIL,
    GROOVED_CRIMP_WITH_LOOP,
    CRIMP_COVER,
    HEAD_PIN,
    EYE_PIN,
    SAFETY_PIN,
    BAR_PIN,
    BAIL,
    ALLIGATOR_CLIP,
    JUMP_RING,
    CLOSED_JUMP_RING,
    SPLIT_RING,
    CONNECTOR,
    SPACER;

    @Override
    public String toString(){
        return name().toLowerCase().replace('_',' ');
    }
}
